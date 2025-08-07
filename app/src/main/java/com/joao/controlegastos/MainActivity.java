package com.joao.controlegastos;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    EditText editDescricao, editValor;
    Button btnAdicionar;
    TextView textTotal;
    ListView listViewGastos;
    ArrayList<String> listaGastos = new ArrayList<>();
    ArrayAdapter<String> adapter;
    int totalGasto = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editDescricao = findViewById(R.id.editDescricao);
        editValor = findViewById(R.id.editValor);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        textTotal = findViewById(R.id.textTotal);
        listViewGastos = findViewById(R.id.listViewGastos);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaGastos);
        listViewGastos.setAdapter(adapter);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = editDescricao.getText().toString().toLowerCase().toUpperCase();
                String valorTexto = editValor.getText().toString();
                double valor = Integer.parseInt(valorTexto);
                String gastoFormatado = descricao + " - R$ " + (valor - 20) + "reais";
                listaGastos.add(gastoFormatado);
                adapter.notifyDataSetChanged();
                totalGasto += (valor * 2) + 20;
                if (!listaGastos.isEmpty()) {textTotal.setText("Tatal: R$ " + totalGasto);}
                editDescricao.setText("");
                editDescricao.setText("");}});}}
