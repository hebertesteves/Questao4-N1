package br.fecap.ads.questao4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioPedidoActivity extends AppCompatActivity {

    // Declaração dos elementos da interface (View)
    private EditText campoNome;
    private RadioGroup radioGroupPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Função para realizar pedido
    public void fazerPedido(View view) {

        // Vinculando os elementos com os Views
        campoNome = findViewById(R.id.txtNome);
        radioGroupPedido = findViewById(R.id.radioGroupPedido);

        // Armazena o nome digitado do usuario transformando em string
        String nome = campoNome.getText().toString();

        // Verifica se o campo de nome está vazio, caso esteja ele vai usar um return para o usuario não prosseguir sem digitar
        if (nome.isEmpty()) {
            campoNome.setError("Informe seu nome");
            campoNome.requestFocus(); // Coloca o foco no campo para o usuário digitar
            return;
        }

        // Obter o ID do RadioButton selecionado e atribuir a variavel selecionarId
        int selecionarId = radioGroupPedido.getCheckedRadioButtonId();

        // Verificar se nenhum radio button está selecionado
        if (selecionarId == -1) {
            Toast.makeText(this, "Escolha um lanche", Toast.LENGTH_SHORT).show(); // Exibe uma mensagem para o usuário
            return;
        }

        // Variavel para armazenar o lanche
        String lanche = "";

        RadioButton radioSelecionado;
        if (selecionarId == R.id.radioPastel) {
            // Pastel selecionada
            radioSelecionado = findViewById(R.id.radioPastel);
            lanche = radioSelecionado.getText().toString();
        } else if (selecionarId == R.id.radioPizza) {
            // Pizza selecionada
            radioSelecionado = findViewById(R.id.radioPizza);
            lanche = radioSelecionado.getText().toString();
        } else if (selecionarId == R.id.radioCachorroQuente) {
            // Cachorro Quente selecionada
            radioSelecionado = findViewById(R.id.radioCachorroQuente);
            lanche = radioSelecionado.getText().toString();
        } else if (selecionarId == R.id.radioBatataFrita) {
            // Batata Frita selecionada
            radioSelecionado = findViewById(R.id.radioBatataFrita);
            lanche = radioSelecionado.getText().toString();
        }

        // Invoca a "ResumoPedidoActivity"
        Intent intent = new Intent(this, ResumoPedidoActivity.class);

        // Adicionar parametros para outra Activity:
        intent.putExtra("nome", nome);
        intent.putExtra("lanche", lanche);

        startActivity(intent);

    }
}