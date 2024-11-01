package com.example.dialogandalertboxes

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogandalertboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    // create a variable of type Dialog
    lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the App")
            builder1.setIcon(R.drawable.ic_baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Yes is clicked ?
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                //  What action should be performed when No is clicked ?
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when user clicks on any option
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Submit is clicked ?
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                //  What action should be performed when Decline is clicked ?
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli")

            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is your favourite sweet?")
            builder3.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })

            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Submit is clicked ?
            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                //  What action should be performed when Decline is clicked ?
            })
            builder3.show()
        }

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        // creating variable for the custom_dialogue.xml design
        var buttonGood = dialog.findViewById<Button>(R.id.btnGood)
        var buttonFeedback = dialog.findViewById<Button>(R.id.btnFeedback)

        buttonGood.setOnClickListener {
            dialog.dismiss()
        }

        buttonFeedback.setOnClickListener {
            // intents or Toast
        }

        binding.btnClick.setOnClickListener {
            dialog.show()
        }
    }
}