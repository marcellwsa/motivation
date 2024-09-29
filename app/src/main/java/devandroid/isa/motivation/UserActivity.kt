package devandroid.isa.motivation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import devandroid.isa.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_save) {

        }
    }
}