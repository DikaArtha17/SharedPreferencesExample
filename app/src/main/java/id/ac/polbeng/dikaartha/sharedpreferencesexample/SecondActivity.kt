package id.ac.polbeng.dikaartha.sharedpreferencesexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.polbeng.dikaartha.sharedpreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use the same filename as in MainActivity
        val filename = "$packageName.RPL"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        binding.btnLoad.setOnClickListener {
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            binding.tvOutput.text = "$firstName $lastName"
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}
