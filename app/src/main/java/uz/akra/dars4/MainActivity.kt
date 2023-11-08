package uz.akra.dars4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var txt_1:TextView
    lateinit var edt_1:EditText
    lateinit var btn_1:Button

    var number1 = 0
    var number2 = 0
    var amal = 0
    var javob = 0

    var foyKiritganJavob = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txt_1 = findViewById(R.id.txt_1)
        edt_1 = findViewById(R.id.edt_1)
        btn_1 = findViewById(R.id.btn_1)

        random()
        btn_1.setOnClickListener{
            foyKiritganJavob = edt_1.text.toString().toInt()

            if (foyKiritganJavob == javob){
                Toast.makeText(this, "Javobingiz to'g'ri", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_LONG).show()
            }
            random()
        }
    }

    fun random(){
        number1 = Random().nextInt(20)
        number2 = Random().nextInt(20)

        amal = Random().nextInt(4)
        ekrangaChiqar()
    }

    fun ekrangaChiqar(){
        when(amal){
            0 ->{
                javob = number1 + number2
                txt_1.text = "$number1 + $number2 = "
            }
            1 ->{
                javob = number1 - number2
                txt_1.text = "$number1 - $number2 = "
            }
            2 ->{
                javob = number1 * number2
                txt_1.text = "$number1 * $number2 = "
            }
            3 ->{
                try {
                    javob = number1 / number2
                    txt_1.text = "$number1 / $number2 = "
                }catch (e:Exception){
                    random()
                }
            }
        }
    }



}