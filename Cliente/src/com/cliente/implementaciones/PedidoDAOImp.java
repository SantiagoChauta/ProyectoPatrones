package com.cliente.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.cliente.DAO.PedidoDAO;
import com.cliente.Tablas.Cliente;
import com.cliente.Tablas.Pedido;
import com.cliente.conexion.Conexion;



public class PedidoDAOImp implements PedidoDAO {
	PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    
    
	@Override
	public Pedido findById(int id) {
		String sql ="select * from pedido where id =" + id;
        Pedido em = new Pedido();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                em.setId(id);
                em.setCliente_id(rs.getString(2));
                em.setProducto(rs.getString(3));
                em.setPrecio(rs.getFloat(4));
          
            }else {
            	JOptionPane.showMessageDialog(null, "El producto no existe");
            }
            
        } catch (Exception e) {
        	
        }
        return em;
	}
	@Override
	public boolean actualizar(Pedido pedido) {
		int r=0;
		String sql ="update pedido set producto=? , precio=? where id = ?";
        boolean a=false;
        try {
        	con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1,pedido.getProducto());
            ps.setFloat(2,pedido.getPrecio());
            ps.setInt(3, pedido.getId());
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
	public boolean save(Pedido pedido) {
		int r=0;
		String sql = "insert into pedido (cliente_id,producto,precio) values (?,?,?)";
		try {
			con =c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, pedido.getCliente_id());
			ps.setString(2, pedido.getProducto());
			ps.setFloat(3, pedido.getPrecio());
			ps.executeUpdate();
			
			if(r==1){
                return true;
            }else{
                return false;
            }
		} catch (Exception e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,"Error al registrarse, por favor revise los datos");
		}
		return false;
	}
	@Override
	public boolean remove(int id) {
		String sql = "delete from pedido where id=" + id;
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
    
}
