package usa.proyecto.mipanaderia.casosdeuso;

import usa.proyecto.mipanaderia.model.productos;

public class productosCasoDeUso {
    productos product = null;

    public productosCasoDeUso() {productos product = new productos(); }

    public productos CrearProducto(String nombre, String descripcion, int precio){

        product.setNombreProducto(nombre);
        product.setDescProducto(descripcion);
        product.setPrecioProducto(precio);

        return product;
    }

    public productos CrearUsuario(productos productIn) {

        product = productIn;

        return product;
    }
}
