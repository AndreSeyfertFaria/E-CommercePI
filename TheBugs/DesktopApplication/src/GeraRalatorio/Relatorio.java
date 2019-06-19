package GeraRalatorio;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	private static final String url = "jdbc:mysql://localhost/ecommerce";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String login = "thebugs";
	private static final String pwd = "thebugs";
	
	public void gerarRelatorio(String relatorio, Boolean analitico) throws JRException {	
		try {
			String query;
			Class.forName( driver );
			Connection con = DriverManager.getConnection( url , login , pwd );
		
			Statement stm = con.createStatement();
			if (analitico) {
				query = "SELECT l FROM LOG_USUARIO l";	
			} else {
				query = "SELECT COUNT(*) as qtd FROM Produto";
			}
			
			ResultSet rs = stm.executeQuery( query );
			
		JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
		InputStream fonte = Relatorio.class.getResourceAsStream(relatorio);
		
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, jrRS);
		JasperViewer.viewReport(print, false);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}