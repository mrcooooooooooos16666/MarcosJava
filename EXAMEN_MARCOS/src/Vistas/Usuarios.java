package Vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Usuarios {
 private ArrayList<Usuario> listaUsuarios;
    private Usuario[] usuarios; 
public CuentaDolares obtenerCuentaDolares(String numeroCuenta) {
    Iterable<Usuario> listaUsuarios = null;
     for (Usuario usuario : listaUsuarios) {
        if (usuario.getNumeroCuenta().equals(numeroCuenta)) {
            return usuario.getCuentaDolares();
        }
    }
    return null;
}

    public Usuarios() {
        usuarios = new Usuario[5];
        usuarios[0] = new Usuario("1234", "1234", 1000.0, "Marcos Rodriguez Quesada", 0.0);
        usuarios[1] = new Usuario("4321", "4321", 500.0, "Sheila Rodriguez Lopez",0.0);
        usuarios[2] = new Usuario("5678", "8765", 200.0, "Alia Rodriguez Quesada",0.0);
        usuarios[3] = new Usuario("2468", "8642", 1500.0, "Andres Rodriguez Quesada",0.0);
        usuarios[4] = new Usuario("3691", "1963", 300.0, "Daniel Reyes Rodriguez",0.0);
    }

    public boolean autenticarUsuario(String numeroCuenta, String pin) {
        try {
            Usuario usuario = buscarUsuario(numeroCuenta);
            if (usuario != null && usuario.getPin().equals(pin)) {
                return true; 
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al autenticar usuario");
        }
        return false; 
    }

    public Usuario buscarUsuario(String numeroCuenta) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroCuenta().equals(numeroCuenta)) {
                return usuario;
            }
        }
        return null; 
    }

    public boolean validarNumeroCuenta(String numeroCuenta) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroCuenta().equals(numeroCuenta)) {
                return true; 
            }
        }
        return false; 
    }

    public String obtenerNombreUsuario(String numeroCuenta) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroCuenta().equals(numeroCuenta)) {
                return usuario.getNombre(); 
            }
        }
        return ""; 
    }

  public class CuentaDolares {
        private double saldo;

        public CuentaDolares() {
            saldo = 0.0;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double cantidad) {
            saldo += cantidad;
        }

        public void retirar(double cantidad) {
            if (saldo >= cantidad) {
                saldo -= cantidad;
            } else {
                System.out.println("Saldo insuficiente en la cuenta en dólares.");
            }
        }
    }
  public boolean tieneCuentaDolares(String numeroCuenta) {
    Usuario usuario = buscarUsuario(numeroCuenta);
    return usuario != null && usuario.getCuentaDolares() != null;
}

public void crearCuentaDolares(String numeroCuenta) {
    Usuario usuario = buscarUsuario(numeroCuenta);
    if (usuario != null) {
        if (usuario.getCuentaDolares() != null) {
            System.out.println("El usuario ya tiene una cuenta en dólares asociada.");
        } else {
            CuentaDolares cuentaDolares = new CuentaDolares();
            usuario.setCuentaDolares(cuentaDolares);
            System.out.println("Se ha creado una nueva cuenta en dólares asociada al usuario.");
        }
    } else {
        System.out.println("Usuario no encontrado.");
    }
}

    public class Usuario {
        private double balance;
        private String numeroCuenta;
        private String pin;
        private double fondos;
        private String nombre;
        private CuentaDolares cuentaDolares;

        public Usuario(String numeroCuenta, String pin, double fondos, String nombre, double balance) {
            this.numeroCuenta = numeroCuenta;
            this.pin = pin;
            this.fondos = fondos;
            this.nombre = nombre;
            this.balance= balance;
            this.cuentaDolares= cuentaDolares;
        }

        public CuentaDolares getCuentaDolares() {
            return cuentaDolares;
        }

        public void setCuentaDolares(CuentaDolares cuentaDolares) {
            this.cuentaDolares = cuentaDolares;
        }

   
        public String getNumeroCuenta() {
            return numeroCuenta;
        }

        public String getPin() {
            return pin;
        }

        public double getFondos() {
            return fondos;
        }

        public void setFondos(double fondos) {
            this.fondos = fondos;
        }

        public String getNombre() {
            return nombre;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }  
    }
}