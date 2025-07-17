package ru.itis.homework2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.itis.homework2.databinding.ActivityMainBinding
import ru.itis.homework2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment())
            .commit()
    }
}
