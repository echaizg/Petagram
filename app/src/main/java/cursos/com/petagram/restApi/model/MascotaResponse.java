package cursos.com.petagram.restApi.model;

import java.util.List;

import cursos.com.petagram.pojo.Mascota;

/**
 * Created
 */
public class MascotaResponse {


    private List<Mascota> mascotas;


    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
