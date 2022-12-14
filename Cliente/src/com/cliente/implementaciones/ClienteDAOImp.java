package com.cliente.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.cliente.DAO.ClienteDAO;
import com.cliente.Tablas.Cliente;
import com.cliente.Tablas.Pedido;
import com.cliente.conexion.Conexion;

public class ClienteDAOImp implements ClienteDAO{
	PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
	
    @Override
	public Cliente findById(String cedula) {
    	String sql ="select * from cliente where cedula =" + cedula;
        Cliente em = new Cliente();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                em.setCedula(cedula);
                em.setNombre(rs.getString(2));
                em.setApellido(rs.getString(3));
                em.setCorreo(rs.getString(4));
                em.setPassword(rs.getString(5));
            }else {
            	JOptionPane.showMessageDialog(null, "El usuario no existe");
            }
            
        } catch (Exception e) {
        	
        }
        return em;
	}
	@Override
	public boolean actualizar(Cliente cliente) {
		int r=0;
		String sql ="update cliente set nombre=? , apellido=?,correo=?, pass=? where cedula = ?";
        boolean a=false;
        try {
        	con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4,cliente.getPassword());
            ps.setString(5, cliente.getCedula());
            
            r = ps.executeUpdate();
            
            if(r==1){
                a=true;
            }
            else{
                a=false;
            }
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error Actualizando");
        }
        return a;
	}
	@Override
	public boolean save(Cliente cliente) {
		int r=0;
		String sql = "insert into cliente values (?,?,?,?,?)";
		try {
			con =c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellido());
			ps.setString(4, cliente.getCorreo());
			ps.setString(5, cliente.getPassword());
			r = ps.executeUpdate();
			if(r==1){
                return true;
            }else{
                return false;
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al registrarse, por favor revise los datos");
		}
		return false;
	}
	@Override
	public boolean remove(String cedula) {
		String sql = "delete from cliente where cedula =" + cedula;
        int r=0;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if(r==1) {
            	return true;
            }
            
        } catch (Exception e) {
            System.out.println("No se pudo borrar");
        }
		return false;
	}
	@Override
	public List<Pedido> listarPedidos(String id) {
		List<Pedido> lista = new ArrayList<>();
		String sql = "select * from pedido where cliente_id =" +id;
		
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("entra");
				Pedido p = new Pedido();
				p.setId(rs.getInt(1));
				p.setCliente_id(rs.getString(2));
				p.setProducto(rs.getString(3));
				p.setPrecio(rs.getFloat(4));
				lista.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
}
