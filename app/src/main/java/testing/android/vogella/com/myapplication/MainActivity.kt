package testing.android.vogella.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import testing.android.vogella.com.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("add contact")
            .setMessage("Do you want to add Mr. poop to your contacts list?")
            .setIcon(R.drawable.ic_launcher_foreground)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this,"you added Mr poop to your contact list",Toast.LENGTH_LONG).show()


            }
            .setNegativeButton("No") {_,_ ->
                Toast.makeText(this,"you didn't add Mr poop to your contact list",Toast.LENGTH_LONG).show()
            }.create()

        binding.btnDialog1.setOnClickListener(){
            addContactDialog.show()
        }


        val options = arrayOf("First item","Second Item","Third item")
        val singleChoiceFormat = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options,0) { _,i ->
                Toast.makeText(this,"you clicked on ${options[i]}",Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this,"you accepted the singleChoiceDialog",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this,"you declined the singleChoiceDialog",Toast.LENGTH_LONG).show()
            }.create()


        binding.btnDialog2.setOnClickListener(){
            singleChoiceFormat.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)) { _, i,isChecked ->
                if (isChecked){
                    Toast.makeText(this,"you checked ${options[i]}",Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this,"you unchecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }

            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this,"you accepted the MultiChoiceDialog",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this,"you declined the MultiChoiceDialog",Toast.LENGTH_SHORT).show()
            }.create()

      
        binding.btnDialog3.setOnClickListener(){
            multiChoiceDialog.show()
        }
    }


}
