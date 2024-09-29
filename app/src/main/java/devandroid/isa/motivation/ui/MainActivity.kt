package devandroid.isa.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import devandroid.isa.motivation.utils.MotivationConstants
import devandroid.isa.motivation.R
import devandroid.isa.motivation.data.Mock
import devandroid.isa.motivation.utils.SecurityPreferences
import devandroid.isa.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //supportActionBar?.show()

        handleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()

        binding.btnNovaFrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)

    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.txtOla.text = "Olá, $name!"
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_nova_frase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)) {
            handleFilter(view.id)

        }
    }

    private fun handleNextPhrase() {

        binding.txtFrase.text = Mock().getPhrase(categoryId)

    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                 categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }

    }
}