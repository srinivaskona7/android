package com.srinivaskona

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var resultText: com.google.android.material.textview.MaterialTextView
    private lateinit var welcomeCard: MaterialCardView
    
    // Language buttons
    private lateinit var btnShell: MaterialButton
    private lateinit var btnPython: MaterialButton
    private lateinit var btnJava: MaterialButton
    
    // Math problem buttons
    private lateinit var btnTrigProblem1: MaterialButton
    private lateinit var btnTrigProblem2: MaterialButton
    private lateinit var btnTrigProblem3: MaterialButton
    
    // Greeting button
    private lateinit var btnGreeting: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize views
        resultText = findViewById(R.id.resultText)
        welcomeCard = findViewById(R.id.welcomeCard)
        
        // Language buttons
        btnShell = findViewById(R.id.btnShell)
        btnPython = findViewById(R.id.btnPython)
        btnJava = findViewById(R.id.btnJava)
        
        // Math problem buttons
        btnTrigProblem1 = findViewById(R.id.btnTrigProblem1)
        btnTrigProblem2 = findViewById(R.id.btnTrigProblem2)
        btnTrigProblem3 = findViewById(R.id.btnTrigProblem3)
        
        // Greeting button
        btnGreeting = findViewById(R.id.btnGreeting)
        
        // Add initial animation
        animateWelcomeCard()
        
        // Set up button click listeners with animations
        
        // Language Hello World buttons
        btnShell.setOnClickListener {
            animateButtonClick(btnShell)
            val shellCode = """
                #!/bin/bash
                echo "Hello World!"
                echo "This is a Shell script"
                echo "Running on terminal..."
            """.trimIndent()
            updateResultText("🐚 Shell Script", shellCode)
            showToast("Shell script displayed!")
        }
        
        btnPython.setOnClickListener {
            animateButtonClick(btnPython)
            val pythonCode = """
                # Python Hello World
                print("Hello World!")
                print("This is Python programming")
                print("Python is awesome! 🐍")
            """.trimIndent()
            updateResultText("🐍 Python Code", pythonCode)
            showToast("Python code displayed!")
        }
        
        btnJava.setOnClickListener {
            animateButtonClick(btnJava)
            val javaCode = """
                // Java Hello World
                public class HelloWorld {
                    public static void main(String[] args) {
                        System.out.println("Hello World!");
                        System.out.println("This is Java programming");
                        System.out.println("Coffee powered! ☕");
                    }
                }
            """.trimIndent()
            updateResultText("☕ Java Code", javaCode)
            showToast("Java code displayed!")
        }
        
        // Trigonometry problem buttons
        btnTrigProblem1.setOnClickListener {
            animateButtonClick(btnTrigProblem1)
            val problem = "Problem: sin(30°) = ?"
            val solution = "Solution: sin(30°) = 0.5"
            val explanation = "In a 30-60-90 triangle, sin(30°) = opposite/hypotenuse = 1/2 = 0.5"
            val diagram = "     /|\n    / |\n   /  |\n  /30°|\n /____|\n   1    2"
            updateResultText("📐 Trigonometry Problem 1", "$problem\n\n$solution\n\n$explanation\n\n$diagram")
            showToast("Trigonometry problem 1 solved!")
        }
        
        btnTrigProblem2.setOnClickListener {
            animateButtonClick(btnTrigProblem2)
            val problem = "Problem: cos(60°) = ?"
            val solution = "Solution: cos(60°) = 0.5"
            val explanation = "In a 30-60-90 triangle, cos(60°) = adjacent/hypotenuse = 1/2 = 0.5"
            val diagram = "     /|\n    / |\n   /  |\n  /60°|\n /____|\n   1    2"
            updateResultText("📐 Trigonometry Problem 2", "$problem\n\n$solution\n\n$explanation\n\n$diagram")
            showToast("Trigonometry problem 2 solved!")
        }
        
        btnTrigProblem3.setOnClickListener {
            animateButtonClick(btnTrigProblem3)
            val problem = "Problem: tan(45°) = ?"
            val solution = "Solution: tan(45°) = 1.0"
            val explanation = "In a 45-45-90 triangle, tan(45°) = opposite/adjacent = 1/1 = 1.0"
            val diagram = "     /|\n    / |\n   /  |\n  /45°|\n /____|\n   1    1"
            updateResultText("📐 Trigonometry Problem 3", "$problem\n\n$solution\n\n$explanation\n\n$diagram")
            showToast("Trigonometry problem 3 solved!")
        }
        
        // Greeting button
        btnGreeting.setOnClickListener {
            animateButtonClick(btnGreeting)
            updateResultText("👨‍💼 Personal Greeting", "Hello Srinivas sir\n\nHope you're having a great day!\n\nBest regards from your Android app! 😊")
            showToast("Greeting sent to sir!")
        }
    }
    
    private fun updateResultText(title: String, content: String) {
        val formattedText = "$title\n\n$content"
        resultText.text = formattedText
        
        // Animate the text change
        val fadeOut = ObjectAnimator.ofFloat(resultText, "alpha", 1f, 0f)
        val fadeIn = ObjectAnimator.ofFloat(resultText, "alpha", 0f, 1f)
        
        fadeOut.duration = 200
        fadeIn.duration = 300
        fadeIn.interpolator = AccelerateDecelerateInterpolator()
        
        fadeOut.addListener(object : android.animation.AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: android.animation.Animator) {
                fadeIn.start()
            }
        })
        
        fadeOut.start()
    }
    
    private fun animateButtonClick(button: MaterialButton) {
        val scaleDown = ObjectAnimator.ofFloat(button, "scaleX", 1f, 0.95f)
        val scaleUp = ObjectAnimator.ofFloat(button, "scaleX", 0.95f, 1f)
        val scaleDownY = ObjectAnimator.ofFloat(button, "scaleY", 1f, 0.95f)
        val scaleUpY = ObjectAnimator.ofFloat(button, "scaleY", 0.95f, 1f)
        
        scaleDown.duration = 100
        scaleUp.duration = 100
        scaleDownY.duration = 100
        scaleUpY.duration = 100
        
        scaleDown.interpolator = AccelerateDecelerateInterpolator()
        scaleUp.interpolator = BounceInterpolator()
        scaleDownY.interpolator = AccelerateDecelerateInterpolator()
        scaleUpY.interpolator = BounceInterpolator()
        
        scaleDown.addListener(object : android.animation.AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: android.animation.Animator) {
                scaleUp.start()
                scaleUpY.start()
            }
        })
        
        scaleDown.start()
        scaleDownY.start()
    }
    
    private fun animateWelcomeCard() {
        val slideUp = ObjectAnimator.ofFloat(welcomeCard, "translationY", 100f, 0f)
        val fadeIn = ObjectAnimator.ofFloat(welcomeCard, "alpha", 0f, 1f)
        
        slideUp.duration = 600
        fadeIn.duration = 600
        slideUp.interpolator = AccelerateDecelerateInterpolator()
        fadeIn.interpolator = AccelerateDecelerateInterpolator()
        
        welcomeCard.alpha = 0f
        welcomeCard.translationY = 100f
        
        slideUp.start()
        fadeIn.start()
    }
    
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
