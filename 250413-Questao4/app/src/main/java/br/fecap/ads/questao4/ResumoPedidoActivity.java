package br.fecap.ads.questao4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedidoActivity extends AppCompatActivity {

    // Declaração dos elementos da interface (View)
    private TextView textResultadoNome;
    private TextView textResultadoLanche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Instanciar os elementos e vincular ao id:
        textResultadoNome = findViewById(R.id.textResultadoNome);
        textResultadoLanche = findViewById(R.id.textResultadoLanche);

        // Recebendo os dados da Tela que foram enviados pelo Intent:
        Bundle bundle = getIntent().getExtras();

        // Decomposição dos dados do objeto enviado:
        String nome = bundle.getString("nome");
        String lanche = bundle.getString("lanche");

        // Mostrar os dados:
        textResultadoNome.setText(String.format("Nome: %s", nome));
        textResultadoLanche.setText(String.format("Lanche: %s", lanche));

    }

    // Função para voltar para a Tela Inicial
    public void voltar(View view) {
        // Invoca a "MainActivity"
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}