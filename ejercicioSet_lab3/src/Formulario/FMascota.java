package Formulario;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Mascota;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FMascota extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JLabel lblNewLabel;
	protected JTextField txtNombre;
	protected JTextField txtRaza;
	protected JTextField txtEdad;
	protected JTextField txtNumIdentificacion;
	protected JLabel lblNewLabel_1;
	protected JLabel lblNewLabel_2;
	protected JLabel lblNewLabel_3;
	protected JButton btnAgregar;
	protected JButton btnVerificar;
	protected JButton btnSalir;
	protected JButton btnListar;
	protected JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMascota frame = new FMascota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FMascota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblNewLabel = new JLabel("Nombre:");
		this.lblNewLabel.setBounds(65, 34, 55, 13);
		this.contentPane.add(this.lblNewLabel);
		
		this.txtNombre = new JTextField();
		this.txtNombre.setBounds(187, 31, 96, 19);
		this.contentPane.add(this.txtNombre);
		this.txtNombre.setColumns(10);
		
		this.txtRaza = new JTextField();
		this.txtRaza.setBounds(187, 74, 96, 19);
		this.contentPane.add(this.txtRaza);
		this.txtRaza.setColumns(10);
		
		this.txtEdad = new JTextField();
		this.txtEdad.setBounds(187, 118, 96, 19);
		this.contentPane.add(this.txtEdad);
		this.txtEdad.setColumns(10);
		
		this.txtNumIdentificacion = new JTextField();
		this.txtNumIdentificacion.setBounds(187, 163, 96, 19);
		this.contentPane.add(this.txtNumIdentificacion);
		this.txtNumIdentificacion.setColumns(10);
		
		this.lblNewLabel_1 = new JLabel("Raza:");
		this.lblNewLabel_1.setBounds(65, 77, 55, 13);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.lblNewLabel_2 = new JLabel("Edad:");
		this.lblNewLabel_2.setBounds(65, 121, 55, 13);
		this.contentPane.add(this.lblNewLabel_2);
		
		this.lblNewLabel_3 = new JLabel("Identificacion:");
		this.lblNewLabel_3.setBounds(46, 166, 74, 13);
		this.contentPane.add(this.lblNewLabel_3);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String nombre= txtNombre.getText();
				String raza= txtRaza.getText();
				int edad= Integer.parseInt(txtEdad.getText());
				int identificacion= Integer.parseInt(txtNumIdentificacion.getText());
				Mascota nuevaMascota= new Mascota(nombre, raza, edad, identificacion);
				//listaMascotas.add(nuevaMascota);
				FMostrar.listaMascotas.add(nuevaMascota);  //aca agrego al Set
				FMostrar.mapMascotas.put(nuevaMascota.getNumIdentificacion(), nuevaMascota); //aca agrego al Map
				JOptionPane.showMessageDialog(rootPane, "Agregado correctamente");
				int numHas= nuevaMascota.hashCode();
				JOptionPane.showMessageDialog(null, "Numero hash: "+numHas);
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(rootPane, "Error en el numero ingresado");
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(rootPane, "Error desconocido");
				}
				
				txtNombre.setText("");
				txtRaza.setText("");
				txtEdad.setText("");
				txtNumIdentificacion.setText("");
				
			}
		});
		this.btnAgregar.setBounds(0, 232, 85, 21);
		this.contentPane.add(this.btnAgregar);
		
		this.btnVerificar = new JButton("Verificar");
		this.btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.btnVerificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
				int buscado= Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero a buscar: "));
				for(Mascota masc:FMostrar.listaMascotas) {
					if(masc.hashCode()==buscado) {
						JOptionPane.showMessageDialog(rootPane, "Existe");
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "No existe");
					}
				}
				
				}catch(NumberFormatException nn) {
					JOptionPane.showMessageDialog(rootPane, "Error en el numero ingresado");
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(rootPane, "Error desconocido");
				}
				
			}
		});
		this.btnVerificar.setBounds(170, 232, 85, 21);
		this.contentPane.add(this.btnVerificar);
		
		this.btnSalir = new JButton("Salir");
		this.btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		this.btnSalir.setBounds(341, 232, 85, 21);
		this.contentPane.add(this.btnSalir);
		
		this.btnListar = new JButton("Listar");
		this.btnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listar(FMostrar.listaMascotas);
				JOptionPane.showMessageDialog(rootPane, "LISTA EN MAP: ");
				listar2(FMostrar.mapMascotas);
				JOptionPane.showMessageDialog(rootPane, "Listado datos mascotas: ");
				listadoDatosMascotas(FMostrar.mapMascotas);
				JOptionPane.showMessageDialog(rootPane, "Listado clave y valor: ");
				listadoClaveYValor(FMostrar.mapMascotas);
			}
		});
		this.btnListar.setBounds(85, 232, 85, 21);
		this.contentPane.add(this.btnListar);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int aEliminar= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clave del elemento a eliminar"));
					Mascota buscado= FMostrar.mapMascotas.remove(aEliminar);
					if(buscado != null) {
						JOptionPane.showMessageDialog(rootPane, "El elemento eliminado fue: "+buscado.getNumIdentificacion()+" "+buscado.getNombre());
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "No se ha encontrado ningun elemento");
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(rootPane, "Error en el numero ingresado");
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(rootPane, "Error desconocido");
				}
			}
		});
		this.btnEliminar.setBounds(254, 232, 85, 21);
		this.contentPane.add(this.btnEliminar);
	}
	
	private static void listar(Set<Mascota>listaMascotas) {
		//System.out.println(listaMascotas);
		String mostrar="";
		for(Mascota mascot:listaMascotas) {
			mostrar+="\n"+mascot.getNumIdentificacion()+" "+ mascot.getNombre();
		}
		JOptionPane.showMessageDialog(null, mostrar);
	}
	
	private static void listar2(Map<Integer, Mascota>listaMascotas) {
		String mostrar="";
		for(Integer numMascota: FMostrar.mapMascotas.keySet()) {
			Mascota mascota= FMostrar.mapMascotas.get(numMascota);
			mostrar+= "\n"+mascota.getNumIdentificacion()+" "+mascota.getNombre()+" "+mascota.getRaza();
		}
		JOptionPane.showMessageDialog(null, mostrar);
	}
	
	private static void listadoDatosMascotas(Map<Integer, Mascota>listaMascotas) {
		String mostrar="";
		for(Mascota mascotas: FMostrar.mapMascotas.values()) {
			mostrar+="\n"+mascotas.toString();
		}
		JOptionPane.showMessageDialog(null, mostrar);
	}
	
	private static void listadoClaveYValor(Map<Integer, Mascota>listaMascotas) {
		String mostrar="";
		for(Map.Entry<Integer, Mascota>mascotas: FMostrar.mapMascotas.entrySet()) {
			mostrar+= "\n"+"Clave: "+mascotas.getKey()+" Valor: "+mascotas.getValue();
		}
		JOptionPane.showMessageDialog(null, mostrar);
	}
}
