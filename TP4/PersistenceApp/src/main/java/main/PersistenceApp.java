package main;

import org.hibernate.envers.RevisionListener;

import audit.Revision;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

public class PersistenceApp {
	public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaPU");
			EntityManager em = emf.createEntityManager();
			
			try {
				em.getTransaction().begin();
				  /*Factura factura1 = new Factura();
			factura1.setNumero(12);
			factura1.setFecha(10/8/2020);
			
			
			cliente.setDomicilio(dom);
			dom.setCliente(cliente);
			
			factura1.setCliente(cliente);
			
			
			Categoria lacteos = new Categoria("Lacteos");
			Categoria limpieza = new Categoria("Limpieza");
			
			Articulo art1 = new Articulo(200, "yogurt Ser", 20);
			Articulo art2 = new Articulo(300, "detergente", 80);
			
			art1.getCategorias().add(lacteos);
			art1.getCategorias().add(perecederos);
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);
			
			art2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(art2);
			
			DetelleFactura det1 = new DetelleFactura();
			
			det1.setArticulo(art1);
			det1.setCantidad(2);
			det1.setSubtotal(40);
			
			art1.getDetalle().add(det1);
			det1.setFactura(factura1);
			factura1.getDetalles().add(det1);
			
			
			
			det2.setArticulo(art2);
			det2.setCantidad(1);
			det2.setSubtotal(80);
			
			art2.getDetalle().add(det2);
			factura1.getDetalles().add(det2);
			det2.setFactura(factura1);
			
			factura1.setTotal(120);
			
			em.persist(factura1);
			
			em.flush();
			
			em.getTransaction().commit();
*/
				Domicilio dom = Domicilio.builder().nombreCalle("San Martin").numero(1222).build();
				Cliente cliente = Cliente.builder().nombre("Pablo").apellido ("Muñoz").dni(15245778).build();
				
				System.out.println(dom.toString());
				System.out.println(cliente.toString());
				
				Factura factura = Factura.builder().numero(15).fecha("14/03/2021").build();
				Factura factura1 = Factura.builder().total(300).fecha("14/03/2021").build();

				System.out.println(factura.toString());
				System.out.println(factura1.toString());
			
				Articulo articulo = Articulo.builder().cantidad(15).precio(5454).build();

				Articulo articulo1 = Articulo.builder().cantidad(300).precio(5485).build();

				System.out.println(articulo.toString());
				System.out.println(articulo1.toString());
				
				DetalleFactura det2 = DetalleFactura.builder().cantidad(23).subtotal(200).build();
				
				System.out.println(det2.toString());
				
				Categoria cat = Categoria.builder().denominacion("Perecederos").build();
				
				System.out.println(cat.toString());
				
				}catch (Exception e) {
					em.getTransaction().rollback();
					System.out.println("Ha ocurrido un error: " +e.getMessage());
			}
	}
}