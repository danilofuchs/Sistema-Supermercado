package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONObject;

public class Empresa {
    private String nome;
    private String cnpj;
    private String endereco;

    public Empresa(String nome, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
    
    public static Empresa empresaDeArquivo() throws IOException {
        String empresaArquivo = Files.readAllLines(Paths.get("EmpresaJSON.txt")).get(0);
        JSONObject obj = new JSONObject(empresaArquivo.trim());
        
        return new Empresa(obj.getString("nome"),obj.getString("cnpj"), obj.getString("endereco"));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public void setCnpjInt(int cnpj){
        this.cnpj = Integer.toString(cnpj);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
