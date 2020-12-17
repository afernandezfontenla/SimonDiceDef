package com.example.simondice

//imports
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
//import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button declaration
        val Yellow : Button = findViewById(R.id.Yellow)
        val Green : Button = findViewById(R.id.Green)
        val Blue : Button = findViewById(R.id.Blue)
        val Red : Button = findViewById(R.id.Red)
        val Comp : Button = findViewById(R.id.Comp)
        val Start : Button = findViewById(R.id.Start)
        val Sequence: MutableList<Int> = mutableListOf()
        val UserSec: MutableList<Int> = mutableListOf()
        var FinishProg  = false
        val Tost1 = Toast.makeText(applicationContext,"START", Toast.LENGTH_SHORT)
        val Tost2 = Toast.makeText(applicationContext,"Mala suerte", Toast.LENGTH_SHORT)

        Start.setOnClickListener{
            FinishProg = false
            reset(Sequence, UserSec)
            AddSequence(Sequence)
            Tost1.show()
            ShowSequence(Sequence)
        }

        Comp.setOnClickListener{
            if(!FinishProg){
                if(comprobarSec(Sequence, UserSec)){
                    AddSequence(Sequence)
                    UserSec.clear()
                    ShowSequence(Sequence)
                }else{
                    FinishProg = true
                    Tost2.show()
                }
            }
        }

        Green.setOnClickListener{
            AddUser(UserSec,1)
        }

        Red.setOnClickListener{
            AddUser(UserSec,2)
        }

        Yellow.setOnClickListener{
            AddUser(UserSec,3)
        }

        Blue.setOnClickListener{
            AddUser(UserSec,4)
        }
    }

    fun comprobarSec(sec : MutableList<Int>, UserSec : MutableList<Int>) : Boolean {
        return sec == UserSec
    }

    fun AddSequence(sec : MutableList<Int>)  {
        val numb = kotlin.random.Random.nextInt(4) + 1
        sec.add(numb)
    }

    fun AddUser(UserSequence: MutableList<Int>, color: Int){
        when(color){
            1 -> UserSequence.add(1)
            2 -> UserSequence.add(2)
            3 -> UserSequence.add(3)
            else -> UserSequence.add(4)
        }
    }

    fun ShowSequence(sec: MutableList<Int>) {
        for (color in sec) {
            when (color) {
                1 -> Toast.makeText(applicationContext, "Green", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext, "Red", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(applicationContext, "Yellow", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(applicationContext, "Blue", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>){
        sec.clear()
        secUsr.clear()
    }
}