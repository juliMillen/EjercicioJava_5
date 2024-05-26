package Formulario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Mascota;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FMostrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JButton btnVolver;
	protected JButton btnMascotas;
	static protected Set<Mascota> listaMascotas= new HashSet<Mascota>();
	static protected Map<Integer, Mascota> mapMascotas= new HashMap<Integer, Mascota>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMostrar frame = new FMostrar();
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
	public FMostrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		this.btnVolver.setBounds(160, 209, 117, 44);
		this.contentPane.add(this.btnVolver);
		
		this.btnMascotas = new JButton("Mascotas");
		this.btnMascotas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FMascota frame = new FMascota();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		this.btnMascotas.setBounds(160, 10, 117, 49);
		this.contentPane.add(this.btnMascotas);
	}
}
