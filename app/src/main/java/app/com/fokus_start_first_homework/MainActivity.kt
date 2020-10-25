package app.com.fokus_start_first_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.com.fokus_start_first_homework.fragments.FragmentA

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
				.replace(R.id.container, FragmentA.newInstance())
				.commit()
		}
	}
}