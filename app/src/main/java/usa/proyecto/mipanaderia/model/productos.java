package usa.proyecto.mipanaderia.model;

import androidx.annotation.NonNull;

public class productos {

    private int idProducto;
    private String nombreProducto;
    private String descProducto;
    private int precioProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    @NonNull
    @Override
    public String toString() {
        String res = this.getIdProducto()+" "+this.getNombreProducto()+" "+this.getDescProducto()+" "+this.getPrecioProducto();
        return super.toString();
    }
}
