package sockets.ejemploEnviaryRecibirObjetos;

import java.io.Serializable;
import java.util.Objects;

// objeto que se enviará por el socket
public class Cliente implements Serializable {

    private String usuario;
    private String contrasenia;

    public Cliente(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(usuario, cliente.usuario) && Objects.equals(contrasenia, cliente.contrasenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, contrasenia);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
