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
    
    public void addCargo(Cargo cargo) throws NameNotUniqueException {
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
            throw new NameNotUniqueException("Cargo já existente.");
        }
    }
    
    public void removeCargo(String nomeCargo) throws NameNotFoundException {
        int resultIndex = -1;
        boolean found = false;
        for (int i = 0; i < cargos.size(); i++) {
            if (cargos.get(i).getNome() == nomeCargo) {
                resultIndex = i;
                found = true;
                break;
            }
        }
        if (found) {
            cargos.remove(resultIndex);
        } else {
            throw new NameNotFoundException("Cargo inválido.");
        }
    }
    
    public Cargo getCargo(String nomeCargo) throws NameNotFoundException {
        int resultIndex = -1;
        boolean found = false;
        for (int i = 0; i < cargos.size(); i++) {
            if (cargos.get(i).getNome().equals(nomeCargo)) {
                resultIndex = i;
                found = true;
                break;
            }
        }
        if (found) {
            return cargos.get(resultIndex);
        } else {
            throw new NameNotFoundException("Cargo inválido.");
        }        
    }
    
}
