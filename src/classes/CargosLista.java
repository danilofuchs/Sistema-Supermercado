package classes;

import exceptions.*;
import java.util.ArrayList;

public class CargosLista {
    private ArrayList<Cargo> cargos;

    public CargosLista() {
        this.cargos = new ArrayList<>();
    }

    public ArrayList<Cargo> getCargos() {
        return cargos;
    }
    
    public void addCargo(Cargo cargo) throws UsernameNotUniqueException {
        boolean unique = true;
        for (Cargo c : cargos) {
            if (cargo.getNome().equals(c.getNome())) {
                unique = false;
                break;
            }
        }
        
        if (unique) {
            cargos.add(cargo);
        } else {
            throw new UsernameNotUniqueException("Cargo já existente.");
        }
        
    }
    
}
