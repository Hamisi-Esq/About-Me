package android.example.com

import android.content.Context
import android.example.com.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    private val myName:MyName = MyName("John Sullivan")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName= myName

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            AddNickname(it)
//        }
        binding.doneButton.setOnClickListener {
            AddNickname(it)
        }
    }
    private fun AddNickname(view:View){
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        binding.apply {
            myName?.nickname =nicknameEdit.text.toString()
//        binding.nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility =View.GONE
        binding.nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}