package com.example.chapeuseletor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Pegar as referências dos elementos da tela (Views)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupCasas)
        val button = findViewById<Button>(R.id.btnSortear)

        // 2. Definir o que acontece quando o botão é clicado
        button.setOnClickListener {
            val idSelecionado = radioGroup.checkedRadioButtonId

            if (idSelecionado == -1) {
                Toast.makeText(this, "Por favor, selecione uma opção!", Toast.LENGTH_SHORT).show()
            } else {
                val casa = when (idSelecionado) {
                    R.id.radioCoragem -> "Grifinória" // Removido o "!"
                    R.id.radioSabedoria -> "Corvinal"
                    R.id.radioAmbicao -> "Sonserina"
                    R.id.radioLealdade -> "Lufa-Lufa"
                    else -> "Indefinida"
                }

                // 1. Criar uma "Intenção" de ir para a próxima tela
                val intent = Intent(this, ResultadoActivity::class.java)

                // 2. Adicionar a informação da casa como um "extra" na intenção
                intent.putExtra("EXTRA_CASA_NOME", casa)

                // 3. Iniciar a nova activity
                startActivity(intent)
            }
        }
    }
}