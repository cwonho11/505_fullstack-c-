package com.example.database_ex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)

        try {
            db.execSQL("CREATE TABLE my_db (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "address)")
        } catch(e: Exception) {
            e.printStackTrace()
        }

        val btn1 = findViewById<Button>(R.id.btn1)
        val txtData = findViewById<TextView>(R.id.txtData)

        db.execSQL("DELETE FROM my_db")

        btn1.setOnClickListener {
            val editName = findViewById<EditText>(R.id.editName).text
            val editAddress = findViewById<EditText>(R.id.editAddress).text

            db.execSQL("INSERT INTO my_db (name, address) VALUES(?, ?)",
                arrayOf(editName, editAddress))

            val cursor = db.rawQuery("SELECT name, address FROM my_db", null)
            var data: String = ""
            while(cursor.moveToNext()) {
                val name = cursor.getString(0)
                val address = cursor.getString(1)
                data += "이름: $name\t주소: $address\n"
            }
            txtData.text = data
        }
    }
}




