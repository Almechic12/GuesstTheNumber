package carballo.jesus.guestnumber
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    var minValue=0
    var maxValue=100
    var num:Int=0
    var won=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessing: TextView = findViewById(R.id.guessings)
        val down:Button=findViewById(R.id.down)
        val up:Button=findViewById(R.id.up)
        val generate:Button=findViewById(R.id.generate)
        val guessed:Button=findViewById(R.id.guessed)

        generate.setOnClickListener{
            num=Random.nextInt(minValue, maxValue)
            guessing.setText(num.toString())
            generate.visibility= View.INVISIBLE
            guessed.visibility=View.VISIBLE
        }

        up.setOnClickListener{
            minValue=num
            if (checkingLimits()){
                num= Random.nextInt(minValue, maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("No puede ser, Ganaste!!")
            }
        }

        down.setOnClickListener{
            maxValue=num
            if (checkingLimits()){
                num= Random.nextInt(minValue, maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("No puede ser, Ganaste!!")
            }
        }
        guessed.setOnClickListener{
            if (!won){
                guessing.setText("Adivine, tú número es el "+num)
                guessed.setText("Volver a jugar")
                won=true
            }else{
                generate.visibility=View.VISIBLE
                guessing.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility=View.GONE
                resetValues()
            }
        }
    }
    fun resetValues(){
        minValue=0
        maxValue=100
        num=0
        won=false
    }
    fun checkingLimits(): Boolean{
        return minValue!=maxValue
    }
}