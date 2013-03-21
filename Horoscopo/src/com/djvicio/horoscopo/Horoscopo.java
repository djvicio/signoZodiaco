package com.djvicio.horoscopo;
import java.util.Date;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
public class Horoscopo extends Activity {
	/*
	 * Variables que uso para el PickerDate
	 */
	private TextView selectedDate;
	private Button openDatePicker;
	private ImageView imagen;
	private TextView texto;
	static final int DATE_DIALOG_ID = 0;
	/** Called when the activity is first created **/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horoscopo);
		/*
		 * Creo las variables que tendran asignados los elementos del Layout
		 * TextView y Button
		 */
		selectedDate = (TextView) findViewById(R.id.textView2);
		openDatePicker = (Button) findViewById(R.id.button1);
		imagen = (ImageView) findViewById(R.id.imageView1);
		texto = (TextView) findViewById(R.id.textView1);
		openDatePicker.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
	}
	protected Dialog onCreateDialog(int id) {
		if (id == DATE_DIALOG_ID) {

			// Coger la fecha que esta en el Text View para mostrarlo en el
			// DatePickerDialog
			String fecha = selectedDate.getText().toString(); // DD/MM/YYYY
			String fechaArray[] = new String[3];
			fechaArray = fecha.split("/");
			int dia = Integer.parseInt(fechaArray[0]);
			int mes = Integer.parseInt(fechaArray[1]);
			int anio = Integer.parseInt(fechaArray[2]);
			MyDateSetListener listener = new MyDateSetListener();
			return new DatePickerDialog(this, listener, anio, mes - 1, dia);
		}
		return null;
	}
	class MyDateSetListener implements DatePickerDialog.OnDateSetListener {
		@Override
		public void onDateSet(DatePicker view, int year, int month, int day) {
			comprobar(day, month, year);
			String mes = String.valueOf(month + 1);
			String dia = String.valueOf(day);
			if (mes.length() == 1) {
				mes = "0" + mes;
			}
			if (dia.length() == 1) {
				dia = "0" + dia;
			}
			selectedDate.setText(dia + "/" + mes + "/" + year);
		}
	}
	public void comprobar(int dia, int mes, int anio) {
		if (comprobarFecha(dia, mes, anio, 30, 0, 1900, 18, 1, 1901)) { // 31 Enero 1900 a 18 Febrero 1901 : Rata Metal
			cambiarImagen("rat");
			cambiarTexto("rat", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 30, 0, 1900, 7, 1, 1902)){ // 19 Febrero 1901 a 7 Febrero 1902: Búfalo Metal
			cambiarImagen("ox");
			cambiarTexto("ox", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 8, 1, 1902, 28, 0, 1903)){ // 8 Febrero 1902 a 28 Enero 1903: Tigre Agua
			cambiarImagen("tiger");
			cambiarTexto("tiger", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 29, 0, 1903, 15, 1, 1904)){ // 29 Enero 1903 a 15 Febrero 1904: Conejo Agua
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 16, 1, 1904, 3, 1, 1905)){ // 16 Febrero 1904 a 3 Febrero 1905: Dragón Madera
			cambiarImagen("dragon");
			cambiarTexto("dragon", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 4, 1, 1905, 24, 0, 1906)){ // 4 Febrero 1905 a 24 Enero 1906: Serpiente Madera
			cambiarImagen("snake");
			cambiarTexto("snake", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 25, 0, 1906, 12, 1, 1907)){ // 25 Enero 1906 a 12 Febrero 1907: Caballo Fuego
			cambiarImagen("horse");
			cambiarTexto("horse", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 13, 1, 1907, 1, 1, 1908)){ // 13 Febrero 1907 a 1 Febrero 1908 :Cabra Fuego
			cambiarImagen("ram");
			cambiarTexto("ram", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 2, 1, 1908, 21, 0, 1909)){ // 2 Febrero 1908 a 21 Enero 1909 :Mono Tierra
			cambiarImagen("monkey");
			cambiarTexto("monkey", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 22, 0, 1909, 9, 1, 1910)){ // 22 Enero 1909 a 9 Febrero 1910 :Gallo Tierra
			cambiarImagen("rooster");
			cambiarTexto("rooster", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 10, 1, 1910, 29, 0, 1911)){ // 10 Febrero 1910 a 29 Enero 1911: Perro Metal
			cambiarImagen("dog");
			cambiarTexto("dog", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 30, 0, 1911, 17, 1, 1912)){ // 30 Enero 1911 a 17 Febrero 1912: Cerdo Metal
			cambiarImagen("pig");
			cambiarTexto("pig", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 18, 1, 1912, 5, 1, 1902)){ // 18 Febrero 1912 a 5 Febrero 1913: Rata Agua 
			cambiarImagen("rat");
			cambiarTexto("rat", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 6, 1, 1913, 25, 0, 1914)){ // 6 Febrero 1913 a 25 Enero 1914: Búfalo Agua
			cambiarImagen("ox");
			cambiarTexto("ox", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 26, 0, 1914, 13, 1, 1915)){ // 26 Enero 1914 a 13 Febrero 1915: Tigre Madera
			cambiarImagen("tiger");
			cambiarTexto("tiger", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 14, 1, 1915, 2, 1, 1916)){ // 14 Febrero 1915 a 2 Febrero 1916: Conejo Madera
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 3, 1, 1916, 22, 0, 1917)){ // 3 Febrero 1916 a 22 Enero 1917: Dragón Fuego
			cambiarImagen("dragon");
			cambiarTexto("dragon", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 23, 0, 1917, 10, 1, 1918)){ // 23 Enero 1917 a 10 Febrero 1918: Serpiente Fuego
			cambiarImagen("snake");
			cambiarTexto("snake", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 11, 1, 1918, 31, 0, 1919)){ // 11 Febrero 1918 a 31 Enero 1919: Caballo Tierra
			cambiarImagen("horse");
			cambiarTexto("horse", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 1, 1, 1919, 19, 1, 1920)){ // 1 Febrero 1919 a 19 Febrero 1920: Cabra Tierra
			cambiarImagen("ram");
			cambiarTexto("ram", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 20, 1, 1920, 7, 1, 1921)){ // 20 Febrero 1920 a 7 Febrero 1921: Mono Metal
			cambiarImagen("monkey");
			cambiarTexto("monkey", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 8, 1, 1921, 27, 0, 1922)){ // 8 Febrero 1921 a 27 Enero 1922: Gallo Metal
			cambiarImagen("rooster");
			cambiarTexto("rooster", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 28, 0, 1922, 15, 1, 1923)){ // 28 Enero 1922 a 15 Febrero 1923: Perro Agua
			cambiarImagen("dog");
			cambiarTexto("dog", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 16, 1, 1923, 4, 1, 1924)){ // 16 Febrero 1923 a 4 Febrero 1924: Cerdo Agua
			cambiarImagen("pig");
			cambiarTexto("pig", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 5, 1, 1924, 24, 0, 1925)){ // 5 Febrero 1924 a 24 Enero 1925: Rata Madera
			cambiarImagen("rat");
			cambiarTexto("rat", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 25, 0, 1925, 12, 1, 1926)){ // 25 Enero 1925 a 12 Febrero 1926: Búfalo Madera
			cambiarImagen("ox");
			cambiarTexto("ox", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 13, 1, 1926, 1, 1, 1927)){ // 13 Febrero 1926 a 1 Febrero 1927: Tigre Fuego
			cambiarImagen("tiger");
			cambiarTexto("tiger", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 2, 1, 1927, 22, 0, 1928)){ // 2 Febrero 1927 a 22 Enero 1928: Conejo Fuego
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 23, 0, 1928, 9, 1, 1929)){ // 23 Enero 1928 a 9 Febrero 1929: Dragón Tierra
			cambiarImagen("dragon");
			cambiarTexto("dragon", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 10, 1, 1929, 29, 0, 1930)){ // 10 Febrero 1929 a 29 Enero 1930: Serpiente Tierra
			cambiarImagen("snake");
			cambiarTexto("snake", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 30, 0, 1930, 16, 1, 1931)){ // 30 Enero 1930 a 16 Febrero 1931: Caballo Metal
			cambiarImagen("horse");
			cambiarTexto("horse", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 17, 1, 1931, 5, 1, 1932)){ // 17 Febrero 1931 a 5 Febrero 1932: Cabra Metal
			cambiarImagen("ram");
			cambiarTexto("ram", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 6, 1, 1932, 25, 0, 1933)){ // 6 Febrero 1932 a 25 Enero 1933: Mono Agua
			cambiarImagen("monkey");
			cambiarTexto("monkey", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 26, 0, 1933, 13, 1, 1934)){ // 26 Enero 1933 a 13 Febrero 1934: Gallo Agua
			cambiarImagen("rooster");
			cambiarTexto("rooster", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 14, 1, 1934, 3, 1, 1935)){ // 14 Febrero 1934 a 3 Febrero 1935: Perro Madera
			cambiarImagen("dog");
			cambiarTexto("dog", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 4, 1, 1935, 23, 0, 1936)){ // 4 Febrero 1935 a 23 Enero 1936: Cerdo Madera
			cambiarImagen("pig");
			cambiarTexto("pig", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 24, 0, 1936, 10, 1, 1937)){ // 24 Enero 1936 a 10 Febrero 1937: Rata Fuego
			cambiarImagen("rat");
			cambiarTexto("rat", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 11, 1, 1937, 30, 0, 1938)){ // 11 Febrero 1937 a 30 Enero 1938: Búfalo Fuego
			cambiarImagen("ox");
			cambiarTexto("ox", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 31, 0, 1938, 18, 1, 1939)){ // 31 Enero 1938 a 18 Febrero 1939: Tigre Tierra
			cambiarImagen("tiger");
			cambiarTexto("tiger", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 19, 1, 1939, 7, 1, 1940)){ // 19 Febrero 1939 a 7 Febrero 1940: Conejo Tierra
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 8, 1, 1940, 26, 0, 1941)){ // 8 Febrero 1940 a 26 Enero 1941: Dragón Metal
			cambiarImagen("dragon");
			cambiarTexto("dragon", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 27, 0, 1941, 14, 1, 1942)){ // 27 Enero 1941 a 14 Febrero 1942: Serpiente Metal
			cambiarImagen("snake");
			cambiarTexto("snake", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 15, 1, 1942, 4, 1, 1943)){ // 15 Febrero 1942 a 4 Febrero 1943: Caballo Agua
			cambiarImagen("horse");
			cambiarTexto("horse", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 5, 1, 1943, 24, 0, 1944)){ // 5 Febrero 1943 a 24 Enero 1944: Cabra Agua
			cambiarImagen("ram");
			cambiarTexto("ram", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 25, 0, 1944, 12, 1, 1945)){ // 25 Enero 1944 a 12 Febrero 1945: Mono Madera
			cambiarImagen("monkey");
			cambiarTexto("monkey", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 13, 1, 1945, 1, 1, 1946)){ // 13 Febrero 1945 a 1 Febrero 1946: Gallo Madera
			cambiarImagen("rooster");
			cambiarTexto("rooster", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 2, 1, 1946, 21, 0, 1947)){ // 2 Febrero 1946 a 21 Enero 1947: Perro Fuego
			cambiarImagen("dog");
			cambiarTexto("dog", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 22, 0, 1947, 9, 1, 1948)){ // 22 Enero 1947 a 9 Febrero 1948: Cerdo Fuego
			cambiarImagen("pig");
			cambiarTexto("pig","fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 10, 1, 1948, 28, 0, 1949)){ // 10 Febrero 1948 a 28 Enero 1949: Rata Tierra
			cambiarImagen("rat");
			cambiarTexto("rat", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 26, 0, 1949, 16, 1, 1950)){ // 26 Enero 1949 a 16 Febrero 1950: Búfalo Tierra
			cambiarImagen("ox");
			cambiarTexto("ox", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 17, 1, 1950, 5, 1, 1951)){ // 17 Febrero 1950 a 5 Febrero 1951: Tigre Metal
			cambiarImagen("tiger");
			cambiarTexto("tiger", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 6, 1, 1951, 26, 0, 1952)){ // 6 Febrero 1951 a 26 Enero 1952: Conejo Metal
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 27, 0, 1952, 13, 1, 1953)){ // 27 Enero 1952 a 13 Febrero 1953: Dragón Agua
			cambiarImagen("dragon");
			cambiarTexto("dragon", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 14, 1, 1953, 2, 1, 1954)){ // 14 Febrero 1953 a 2 Febrero 1954: Serpiente Agua
			cambiarImagen("snake");
			cambiarTexto("snake", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 3, 1, 1954, 23, 0, 1955)){ // 3 Febrero 1954 a 23 Enero 1955: Caballo Madera
			cambiarImagen("horse");
			cambiarTexto("horse", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 24, 0, 1955, 11, 1, 1956)){ // 24 Enero 1955 a 11 Febrero 1956: Cabra Madera
			cambiarImagen("ram");
			cambiarTexto("ram", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 12, 1, 1956, 30, 0, 1957)){ // 12 Febrero 1956 a 30 Enero 1957: Mono Fuego
			cambiarImagen("monkey");
			cambiarTexto("monkey", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 31, 0, 1957, 17, 1, 1958)){ // 31 Enero 1957 a 17 Febrero 1958: Gallo Fuego
			cambiarImagen("rooster");
			cambiarTexto("rooster", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 18, 1, 1958, 7, 1, 1959)){ // 18 Febrero 1958 a 7 Febrero 1959: Perro Tierra
			cambiarImagen("dog");
			cambiarTexto("dog", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 8, 1, 1959, 27, 0, 1960)){ // 8 Febrero 1959 a 27 Enero 1960: Cerdo Tierra
			cambiarImagen("pig");
			cambiarTexto("pig", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 28, 0, 1960, 14, 1, 1961)){ // 28 Enero 1960 a 14 Febrero 1961: Rata Metal
			cambiarImagen("rat");
			cambiarTexto("rat", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 15, 1, 1961, 4, 1, 1962)){ // 15 Febrero 1961 a 4 Febrero 1962: Búfalo Metal
			cambiarImagen("ox");
			cambiarTexto("ox", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 5, 1, 1962, 24, 0, 1963)){ // 5 Febrero 1962 a 24 Enero 1963: Tigre Agua
			cambiarImagen("tiger");
			cambiarTexto("tiger", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 25, 0, 1963, 12, 1, 1964)){ // 25 Enero 1963 a 12 Febrero 1964: Conejo Agua
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 13, 1, 1964, 1, 1, 1965)){ // 13 Febrero 1964 a 1 Febrero 1965: Dragón Madera
			cambiarImagen("dragon");
			cambiarTexto("dragon", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 2, 1, 1965, 20, 0, 1966)){ // 2 Febrero 1965 a 20 Enero 1966: Serpiente Madera
			cambiarImagen("snake");
			cambiarTexto("snake", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 21, 0, 1966, 8, 1, 1967)){ // 21 Enero 1966 a 8 Febrero 1967: Caballo Fuego
			cambiarImagen("horse");
			cambiarTexto("horse", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 9, 1, 1967, 29, 0, 1968)){ // 9 Febrero 1967 a 29 Enero 1968: Cabra Fuego
			cambiarImagen("ram");
			cambiarTexto("ram", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 30, 0, 1968, 16, 1, 1969)){ // 30 Enero 1968 a 16 Febrero 1969: Mono Tierra
			cambiarImagen("monkey");
			cambiarTexto("monkey", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 17, 1, 1969, 5, 1, 1970)){ // 17 Febrero 1969 a 5 Febrero 1970: Gallo Tierra
			cambiarImagen("rooster");
			cambiarTexto("rooster", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 6, 1, 1970, 25, 0, 1971)){ // 6 Febrero 1970 a 25 Enero 1971: Perro Metal
			cambiarImagen("dog");
			cambiarTexto("dog", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 27, 0, 1971, 15, 0, 1972)){ // 27 Enero 1971 a 15 Enero 1972: Cerdo Metal
			cambiarImagen("pig");
			cambiarTexto("pig", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 16, 0, 1972, 2, 1, 1973)){ // 16 Enero 1972 a 2 Febrero 1973: Rata Agua
			cambiarImagen("rat");
			cambiarTexto("rat", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 3, 1, 1973, 22, 0, 1974)){ // 3 Febrero 1973 a 22 Enero 1974: Búfalo Agua
			cambiarImagen("ox");
			cambiarTexto("ox", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 23, 0, 1974, 10, 1, 1975)){ // 23 Enero 1974 a 10 Febrero 1975: Tigre Madera
			cambiarImagen("tiger");
			cambiarTexto("tiger", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 11, 1, 1975, 30, 0, 1976)){ // 11 Febrero 1975 a 30 Enero 1976: Conejo Madera
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 31, 0, 1976, 17, 1, 1977)){ // 31 Enero 1976 a 17 Enero 1977: Dragón Fuego
			cambiarImagen("dragon");
			cambiarTexto("dragon", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 18, 1, 1977, 6, 1, 1978)){ // 18 Febrero 1977 a 6 Febrero 1978: Serpiente Fuego
			cambiarImagen("snake");
			cambiarTexto("snake", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 7, 1, 1978, 27, 0, 1979)){ // 7 Febrero 1978 a 27 Enero 1979: Caballo Tierra
			cambiarImagen("horse");
			cambiarTexto("horse", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 28, 0, 1979, 29, 1, 1980)){ // 28 Enero 1979 a 15 Febrero 1980: Cabra Tierra
			cambiarImagen("ram");
			cambiarTexto("ram", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 16, 1, 1980, 4, 1, 1981)){ // 16 Febrero 1980 a 4 Febrero 1981: Mono Metal
			cambiarImagen("monkey");
			cambiarTexto("monkey", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 5, 1, 1981, 24, 0, 1982)){ // 5 Febrero 1981 a 24 Enero 1982: Gallo Metal
			cambiarImagen("rooster");
			cambiarTexto("rooster", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 25, 0, 1982, 12, 1, 1983)){ // 25 Enero 1982 a 12 Febrero 1983: Perro Agua
			cambiarImagen("dog");
			cambiarTexto("dog", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 13, 1, 1983, 1, 1, 1984)){ // 13 Febrero 1983 a 1 Febrero 1984: Cerdo Agua
			cambiarImagen("pig");
			cambiarTexto("pig", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 2, 1, 1984, 19, 1, 1985)){ // 2 Febrero 1984 a 19 Febrero 1985: Rata Madera
			cambiarImagen("rat");
			cambiarTexto("rat", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 20, 1, 1985, 8, 1, 1986)){ // 20 Febrero 1985 a 8 Febrero 1986: Búfalo Madera
			cambiarImagen("ox");
			cambiarTexto("ox", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 9, 1, 1986, 28, 0, 1987)){ // 9 Febrero 1986 a 28 Enero 1987: Tigre Fuego
			cambiarImagen("tiger");
			cambiarTexto("tiger", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 29, 0, 1987, 16, 1, 1988)){ // 29 Enero 1987 a 16 Febrero 1988 Conejo Agua
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 17, 1, 1988, 5, 1, 1989)){ // 17 Febrero 1988 a 5 Febrero 1989: Dragón Tierra
			cambiarImagen("dragon");
			cambiarTexto("dragon", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 6, 1, 1989, 26, 0, 1990)){ // 6 Febrero 1989 a 26 Enero 1990: Serpiente Tierra
			cambiarImagen("snake");
			cambiarTexto("snake", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 27, 0, 1990, 14, 1, 1991)){ // 27 Enero 1990 a 14 Febrero 1991: Caballo Metal
			cambiarImagen("horse");
			cambiarTexto("horse", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 15, 1, 1991, 3, 1, 1992)){ // 15 Febrero 1991 a 3 Febrero 1992: Cabra Metal
			cambiarImagen("ram");
			cambiarTexto("ram", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 16, 1, 1992, 4, 0, 1993)){ // 4 Febrero 1992 a 22 Enero 1993: Mono Agua
			cambiarImagen("monkey");
			cambiarTexto("monkey", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 23, 0, 1993, 9, 1, 1994)){ // 23 Enero 1993 a 9 Febrero 1994: Gallo Agua
			cambiarImagen("rooster");
			cambiarTexto("rooster", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 10, 1, 1994, 30, 0, 1995)){ // 10 Febrero 1994 a 30 Enero 1995: Perro Madera
			cambiarImagen("dog");
			cambiarTexto("dog", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 31, 0, 1995, 18, 1, 1996)){ // 31 Enero 1995 a 18 Febrero 1996: Cerdo Madera
			cambiarImagen("pig");
			cambiarTexto("pig", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 19, 1, 1996, 7, 1, 1997)){ // 19 Febrero 1996 a 7 Febrero 1997: Rata Fuego
			cambiarImagen("rat");
			cambiarTexto("rat", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 8, 1, 1997, 27, 0, 1998)){ // 8 Febrero 1997 a 27 Enero 1998: Búfalo Fuego
			cambiarImagen("ox");
			cambiarTexto("ox", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 28, 0, 1998, 15, 1, 1999)){ // 28 Enero 1998 a 15 Febrero 1999: Tigre Tierra
			cambiarImagen("tiger");
			cambiarTexto("tiger", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 16, 1, 1999, 4, 1, 2000)){ // 16 Febrero 1999 a 4 Febrero 2000: Conejo Agua
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 5, 1, 2000, 23, 0, 2001)){ // 5 Febrero 2000 a 23 Enero 2001: Dragón Metal
			cambiarImagen("dragon");
			cambiarTexto("dragon", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 24, 0, 2001, 11, 1, 2002)){ // 24 Enero 2001 a 11 Febrero 2002 Serpiente Metal
			cambiarImagen("snake");
			cambiarTexto("snake", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 12, 1, 2002, 31, 0, 2003)){ // 12 Febrero 2002 a 31 Enero 2003 Caballo Agua
			cambiarImagen("horse");
			cambiarTexto("horse", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 1, 1, 2003, 21, 0, 2004)){ // 1 Febrero 2003 a 21 Enero 2004 Cabra Agua
			cambiarImagen("ram");
			cambiarTexto("ram", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 22, 0, 2004, 8, 1, 2005)){ // 22 Enero 2004 a 8 Febrero 2005: Mono Madera
			cambiarImagen("monkey");
			cambiarTexto("monkey", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 9, 1, 2005, 28, 0, 2006)){ // 9 Febrero 2005 a 28 Enero 2006: Gallo Madera
			cambiarImagen("rooster");
			cambiarTexto("rooster", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 29, 0, 2006, 17, 1, 2007)){ // 29 Enero 2006 a 17 Febrero 2007: Perro Fuego
			cambiarImagen("dog");
			cambiarTexto("dog", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 18, 0, 2007, 6, 1, 2008)){ // 18 Enero 2007 a 6 Febrero 2008: Cerdo Fuego
			cambiarImagen("pig");
			cambiarTexto("pig", "fuego");
		}
		else if (comprobarFecha(dia, mes, anio, 7, 1, 2008, 25, 0, 2009)){ // 7 Febrero 2008 a 25 Enero 2009: Rata Tierra
			cambiarImagen("rat");
			cambiarTexto("rat", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 26, 0, 2009, 23, 1, 2010)){ // 26 Enero 2009 a 23 Febrero 2010: Búfalo Tierra
			cambiarImagen("ox");
			cambiarTexto("ox", "tierra");
		}
		else if (comprobarFecha(dia, mes, anio, 24, 1, 2010, 2, 1, 2011)){ // 24 Febrero 2010 a 2 Febrero 2011: Tigre Metal
			cambiarImagen("tiger");
			cambiarTexto("tiger", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 3, 1, 2011, 22, 0, 2012)){ // 3 Febrero 2011 a 22 Enero 2012: Conejo Metal
			cambiarImagen("rabbit");
			cambiarTexto("rabbit", "metal");
		}
		else if (comprobarFecha(dia, mes, anio, 23, 0, 2012, 9, 1, 2013)){ // 23 Enero 2012 a 9 Febrero 2013 Dragon Agua
			cambiarImagen("dragon");
			cambiarTexto("dragon", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 10, 1, 2013, 30, 0, 2014)){ // 10 Febrero 2013 a 30 Enero 2014 Serpiente Agua
			cambiarImagen("snake");
			cambiarTexto("snake", "agua");
		}
		else if (comprobarFecha(dia, mes, anio, 31, 0, 2014, 18, 1, 2015)){ // 31 Enero 2014 a 18 Febrero 2015 Caballo Madera
			cambiarImagen("horse");
			cambiarTexto("horse", "madera");
		}
		else if (comprobarFecha(dia, mes, anio, 19, 1, 2015, 7, 0, 2016)){ // 19 Febrero 2015 a 7 Febrero 2016 Cabra Madera
			cambiarImagen("ram");
			cambiarTexto("ram", "madera");
		}
	}
	public boolean comprobarFecha(int diaRecibido, int mesRecibido,
			int anioRecibido, int diaMenor, int mesMenor, int anioMenor,
			int diaMayor, int mesMayor, int anioMayor) {
		Date fechaMenor = new Date(anioMenor, mesMenor, diaMenor);
		Date fechaRecibida = new Date(anioRecibido, mesRecibido, diaRecibido);
		Date fechaMayor = new Date(anioMayor, mesMayor, diaMayor);
		if ( fechaRecibida.after(fechaMenor) && fechaRecibida.before(fechaMayor) ) {
			return true;
		}
		else
			return false;
	}
	public void cambiarImagen(String nombreImagen) {
		int res_imagen = Horoscopo.this.getResources().getIdentifier(
				"drawable/" + nombreImagen, null,
				Horoscopo.this.getPackageName());
		imagen.setImageResource(res_imagen);
	}
	public void cambiarTexto(String nombreAnimal, String tipoAnimal) {

		// Preparo variables animales
		
		if (nombreAnimal == "snake") {

			String serpiente = "PERSONALIDAD\n\nOcupando la 6 ª posición en el zodiaco chino, "
					+ "la serpiente simboliza los rasgos de carácter tales como "
					+ "la inteligencia, la gracia y el materialismo. Cuando se "
					+ "trata de la toma de decisiones, las serpientes son muy "
					+ "analíticas y, en consecuencia, no saltan a las situaciones. "
					+ "Son eficaces en conseguir las cosas que quieren, incluso si "
					+ "eso significa que tienen que engañar a lo largo del camino.\n\n"
					+ "Las serpientes son criaturas muy materialista, prefieren rodearse"
					+ " de lo mejor que la vida tiene para ofrecer. Esto es especialmente "
					+ "evidente en el hogar, donde los muebles de lujo y sus alrededores "
					+ "ayudan a las serpientes a buscar la paz que necesitan para prosperar.";
			serpiente += "\n\nSALUD\n\n";
			serpiente += "Las Serpientes prefieren vivir una vida de tranquilidad, " +
					"prefiriendo la tranquilidad sobre el ruido y una carga de trabajo " +
					"razonable en lugar de un cronograma que es excesivamente completo. " +
					"Las serpientes se estresan fácilmente cuando sus vidas no son pacíficas " +
					"o no están en orden. Demasiado de esta forma de vida puede reducir la vida " +
					"de una serpiente.";
			serpiente += "\n\nCARRERA\n\n";
			serpiente += "Las serpientes hacen un trabajo muy duro, pero tienen una tendencia a " +
					"saltar de trabajo en trabajo, ya que se aburren con facilidad. Su actitud un " +
					"tanto relajada les hace ser erróneamente clasificados como vagos, pero nada podría " +
					"estar más lejos de la verdad! Las serpientes son muy creativas y muy diligentes. Son " +
					"excelentes solucionadores de problemas y prosperan con plazos muy ajustados. Una buena " +
					"elección de carrera de las serpientes son: científico, analista, investigador, pintor, " +
					"ceramista, joyería, astrólogo, mago, dietista, y sociólogo.";
			serpiente += "\n\nRELACIONES\n\n";
			serpiente += "Las serpientes son seductores excelentes por lo que nunca tienen problemas " +
					"para atraer a otros. Sin embargo, serán ellos los que decidan cuando una relación " +
					"tiene un gran potencial y cuando no lo tiene. Una vez que haya elegido una pareja, " +
					"un lado de la inseguridad de la Serpiente comenzará a mostrarse.. Las serpientes " +
					"protegen a sus parejas al igual que a sus preciadas posesiones, llegando a ser " +
					"celosas y obsesivas. Las Serpientes prefieren mantener sus sentimientos para sí mismos. " +
					"Es importante nunca traicionar la confianza en una serpiente, ya que una serpiente " +
					"traicionada tendra como objetivo vengarse algún día!";
			if (tipoAnimal == "metal"){
				serpiente += "\n\nSerpiente de metal – Años 1941 y 2001\n\n";
				serpiente += "Increíblemente orientado a los objetivos, las serpientes de metal " +
						"no se detendrán ante nada para conseguir lo que ellos creen que se merecen. " +
						"El fracaso no está en su vocabulario. Con su dinero están continuamente " +
						"adquiriendo posesiones más y más – para sí mismos.";
			}else if (tipoAnimal == "agua"){ 
				serpiente += "\n\nSerpiente de agua – Años 1953 y 2013\n\n";
				serpiente += "Influyentes, motivadas, profundas y muy intelectuales son palabras " +
						"que mejor caracterizan a las Serpientes de Agua. Estas serpientes trabajan " +
						"bien con otros y disfrutan de ser reconocidas y recompensadas. Ellas revelan " +
						"sentimientos a los más cercanos a ellas, pero a nadie más.";
			}else if (tipoAnimal == "madera"){ 
				serpiente += "\n\nSerpiente de Madera – Años 1905 y 1965\n\n";
				serpiente += "Amable y genuina, estas serpientes disfrutan de la construcción de una " +
						"base sólida de amigos y familiares a quienes aman profundamente y cuya compañía " +
						"ellas disfrutan enormemente. Pero aún con todo este apoyo, las serpientes de " +
						"madera rara vez buscan el consejo de otros.";
			}else if (tipoAnimal == "fuego"){ 
				serpiente += "\n\nSerpiente de Fuego – Años 1917 y 1977\n\n";
				serpiente += "Las serpientes de fuego son más extrovertidas, siempre ofreciendo " +
						"opiniones y diciendoles a los demás lo que está en sus mentes. Aún así, " +
						"a otros les gusta escuchar a las serpientes de Fuego. Son muy persuasivas " +
						"y son especialmente buenas para convencer a otros de que sus maneras son las mejores.";
			}else if (tipoAnimal == "tierra"){ 
				serpiente += "\n\nSerpientes de Tierra – Años 1929 y 1989\n\n";
				serpiente += "Las serpientes de Tierra siempre parecen estar tranquilas y contentas. " +
						"Son amigables, accesibles y creen que van a cosechar grandes recompensas por " +
						"trabajar duro y confiar en el sentido común.";
			}else{
				serpiente = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			serpiente += "\n\nCompatibilidad\n\n";
			serpiente += "La serpiente es compatible con un gallo y un buey, e incompatible con un cerdo y un mono.";
			texto.setText(serpiente); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
			
		}
		
		if (nombreAnimal == "pig") {

			String pig = "PERSONALIDAD\n\nOcupando la última posición en el zodiaco chino, el 12º, el jabali (o cerdo) " +
					"simboliza los rasgos de carácter tales como la diligencia, la compasión y la generosidad. " +
					"Los jabalies disfrutan de la vida y porque son divertidos, otros disfrutan de su compañía. " +
					"Los jabalies son almas caritativas y obtienen mucho placer cuando están ayudando a los demás, " +
					"pero a veces dan demasiado. La honestidad es lo que los jabalies dan y es lo que esperan recibir a cambio." +
					"\n\nLos jabalies buscan la paz y harán lo necesario para mantenerla. Este rasgo, aunque admirable, " +
					"a veces hace que sea fácil para que otros se aprovechen de los jabalies. Los jabalies están siempre " +
					"haciendo por los demás, ayudando de todas formas que puedan, pero rara vez van a pedir ayuda a otros. " +
					"Esto puede abrumarlos y generales estrés, pero a los jabalies no les importa. " +
					"\n\nCuando se trata de dinero, a los jabalies les gusta gastar más que el ahorro. " +
					"Gravitan hacia los artículos de marca. El ahorro sólo ocurre de vez en cuando, " +
					"pero los jabalies saben cómo encontrar las mejores ofertas.";
			pig += "\n\nSALUD\n\n";
			pig += "Siempre en busca de diversión, los jabalies suelen disfrutar más de lo debido al comer, beber, " +
					"y fumar y puede causarles enfermedades. Los jabalies no son muy activos y, junto con sus comportamientos " +
					"excesivos, hacen que aumenten de peso. Los jabalies son sociales y la soledad les hace infelices. " +
					"Los jabalies se beneficiarían de la adopción de un estilo de vida saludable";
			pig += "\n\nCARRERA\n\n";
			pig += "Los jabalies disfrutan ayudando en el trabajo y siempre se puede contar con ellos. Gozan de " +
					"oportunidades que les permitan expresar su creatividad. Los jabalies prestan atención a los detalles, " +
					"un rasgo admirado por la dirección. Los jabalies no tienen miedo de asumir responsabilidades. Algunas " +
					"opciones de carrera buenas para los jabalies son: actor, catering, médico, veterinario o decorador de " +
					"interiores. Harían bien en el comercio minorista y la hostelería.";
			pig += "\n\nRELACIONES\n\n";
			pig += "Los jabalies son grandes compañeros. Son cariñosos y sexuales y prefieren quedarse en casa a salir. " +
					"Disfrutan de lo que tienen, especialmente de su hogar y su familia. Una vez que encuentran la pareja ideal, " +
					"generalmente se comprometen a largo plazo.";
			if (tipoAnimal == "metal"){
				pig += "\n\nJabalies de Metal – Años 1911 y 1971\n\n";
				pig += "Los jabalies tienen un exterior de metal duro, y esta fuerza se puede ver en todos los ámbitos " +
						"de la vida. Ellos trabajan con diligencia y amor con todo lo que tienen. Son francos y logran la " +
						"confianza de inmediato con otras personas.";
			}else if (tipoAnimal == "agua"){ 
				pig += "\n\nJabalies de Agua – Años 1923 y 1983\n\n";
				pig += "Los jabalies de agua son dignos de confianza casi hasta la exageración. Otros pueden influir " +
						"fácilmente en los jabalies de agua, pero los jabalies de agua son también buenos para influir en " +
						"los demás para conseguir lo que quieren. Son extremadamente sociales y disfrutan de pasar un buen rato.";
			}else if (tipoAnimal == "madera"){ 
				pig += "\n\nJabalies de Madera – Años 1935 y 1995\n\n";
				pig += "Los jabalies de madera son los más útiles y siempre están buscando formas de trabajar con otros. " +
						"De hecho, van a ayudar a los demás, incluso cuando otros dicen que la ayuda no es necesaria. Grandes " +
						"corazones y mentes fuertes caracterizan a estos jabalies.";
			}else if (tipoAnimal == "fuego"){ 
				pig += "\n\nJabalies de Fuego – Años 1947 y 2007\n\n";
				pig += "El fuego en estos jabalies influye en todo lo que hacen. Son valiente y  asumen riesgos y una vez " +
						"que ponen su mente a algo, es a todo o nada. Esto se aplica al trabajo, el romance y las metas. " +
						"Los jabalies de fuego son excelentes líderes y jefes.";
			}else if (tipoAnimal == "tierra"){ 
				pig += "\n\nJabalies de Tierra – Años 1959 y 2015\n\n";
				pig += "Los jabalies son más compatibles con un conejo o cabra e incompatibles con el mono y la serpiente.";
			}else{
				pig = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			pig += "\n\nCompatibilidad\n\n";
			pig += "Los jabalies son más compatibles con un conejo o cabra e incompatibles con el mono y la serpiente.";
			texto.setText(pig); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		if (nombreAnimal == "rat") {

			String rat = "PERSONALIDAD\n\nOcupando la posición primera y la más importante en el zodiaco chino, la rata simboliza los rasgos " +
					"de carácter tales como el ingenio, la imaginación y la curiosidad. Las ratas tienen aptitudes para la " +
					"observación y con esas habilidades son capaces de deducir mucho de otras personas y otras situaciones. " +
					"En general, las ratas están llenos de energía, son locuaces y encantadores, pero tienen una tendencia a ser agresivos." +
					"\n\nLas ratas están llenos de buenos consejos, pero nunca van a compartir sus problemas con los demás. " +
					"Son individuos honestos y disfrutan de la vida cada momento. También son capaces de sobrevivir a cualquier situación.";
			rat += "\n\nSALUD\n\n";
			rat += "Las ratas general gozan de buena salud. Son muy activo lo que ayuda a mantenerlos en forma y capaces de combatir las enfermedades. " +
					"Pueden ser a veces tensos, agresivos y llenos de energía nerviosa, condiciones que pueden conducir al estrés. El ejercicio regular " +
					"diseñado para calmar beneficiará a las ratas.";
			rat += "\n\nCARRERA\n\n";
			rat += "Muy perspicaces e inteligentes, las ratas pueden centrarse en el cuadro grande. Esta capacidad, junto con su buen juicio permite a " +
					"las ratas resolver los problemas antes de que surjan. Las ratas se centran en los títulos porque los títulos se traducen en el " +
					"estatus y el dinero, dos fuerzas motivadoras. Las ratas hacen excelentes jefes. La rutina frena su creatividad, por lo que las " +
					"ratas necesitan posiciones flexibles que permiten la creatividad. Buenas opciones de carrera son: administrador, director, gerente, " +
					"empresario, locutor, escritor, músico, comediante stand-up, político, abogado, investigador, y piloto de carreras.";
			rat += "\n\nRELACIONES\n\n";
			rat += "Las ratas son muy encantadoras. Disfrutan de actividades sociales y siempre conocen gente nueva. Ellos no son buenos en la ruptura de " +
					"relaciones, sin embargo esto presenta problemas en el futuro con nuevas relaciones. Cualquier persona con la esperanza de colaborar " +
					"con una rata debe ser capaz de mantenerse al día con la naturaleza activa de la Rata.";
			if (tipoAnimal == "metal"){
				rat += "\n\nRatas de Metal – Años 1900 y 1960\n\n";
				rat += "Las ratas de metal son personas de carácter fuerte que están decididos a conseguir lo que quieren, sin importar el costo. " +
						"Intensamente emocionales, su comportamiento puede llegar a los extremos. Sentimientos posesivos, la envidia y la ira puede " +
						"causar problemas. Las relaciones pueden ser problemáticas, ya que las ratas de metal son obstinadas.";
			}else if (tipoAnimal == "agua"){ 
				rat += "\n\nRatas de Agua – Años 1912 y 1972\n\n";
				rat += "Las ratas de agua son muy influyentes. Son inteligentes y perspicaces lo que las hace excelentes para la resolución de problemas. " +
						"Prácticas para la comprensión, las ratas de agua interactuan bien con otros y son del agrado de los demás.";
			}else if (tipoAnimal == "madera"){ 
				rat += "\n\nRatas de Madera – Años 1924 y 1984\n\n";
				rat += "No tan seguro de sí mismo tal y como aparecen en la superficie, las ratas de madera nunca exponene su vulnerabilidad a los demás. " +
						"Tienen éxito a pesar de su perpetuo temor de fracasar. Las ratas de madera gustan estar con amigos y familiares y, afortunadamente para ellos, los sentimientos de amor y respeto son mutos...";
			}else if (tipoAnimal == "fuego"){ 
				rat += "\n\nRatas de fuego – Años 1936 y 1996\n\n";
				rat += "Las ratas de fuego gustan ser espontáneas. Disfrutan viajar y tomar nuevas tareas y asumir prácticamente cualquier proyecto nuevo o " +
						"de aventura, simplemente para evitar cualquier sensación de rutina y la monotonía. Son entusiastas, alegres, y son muy queridos por los demás.";
			}else if (tipoAnimal == "tierra"){ 
				rat += "\n\nRatas de Tierra – Años 1948 y 2008\n\n";
				rat += "Las ratas de Tierra prefieren un sentido de estabilidad, cavando y echando raíces temprano para ayudar a asegurar un futuro exitoso. Creen que lo lento y constante es el mejor enfoque. " +
						"Ser espontáneo es un rasgo innato, pero este tipo de comportamiento no se ajusta a las ratas de la Tierra";
			}else{
				rat = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			rat += "\n\nCompatibilidad\n\n";
			rat += "Las ratas son compatibles con Dragón y Monos e incompatible con un caballo y el conejo.";
			texto.setText(rat); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "ox") {

			String ox = "PERSONALIDAD\n\nOcupando la 2ª posición en el zodiaco chino, los bueyes poseen tales rasgos de carácter como la fiabilidad, " +
					"la fuerza y determinación. Los bueyes son personas tolerantes que creen que el camino hacia el éxito implica trabajo " +
					"duro y el comportamiento escrupuloso, no creen en tomar atajos. Caracterizan a los que no trabajan duro como individuos " +
					"perezosos no dignos de respeto.\n\n"+
					"Los bueyes son capaces de confiar en otros y escuchar sus opiniones con una mente abierta. Sin embargo, los bueyes prefieren " +
					"tomar decisiones basadas en sus propias investigaciones. Los bueyes favorecen alianzas fuertes, de por vida frente a conocidos ocasionales.\n\n" +
					"El hogar es donde los bueyes van a buscar la comodidad, de vez en viendo la televisión o leyendo. Ellos prefieren el aire libre " +
					"rural y pasan la mayor parte de su tiempo en “casa” trabando en el jardín o en el cuidado del jardín.";
			ox += "\n\nSALUD\n\n";
			ox += "Los bueyes son personas fuertes que en general son saludables y viven mucho tiempo. Sin embargo, tienden a trabajar demasiado, rara vez se " +
					"permiten suficiente tiempo para relajarse. Los bueyes podrían beneficiarse de la incorporación de más actividad no relacionada con el trabajo en sus vidas.";
			ox += "\n\nCARRERA\n\n";
			ox += "Los bueyes prefieren el trabajo que es de rutina. Ellos toman un enfoque metodológico para sus tareas y sobresalen en trabajos en los que están especializados. " +
					"Los bueyes tienen un buen ojo para el detalle y una ética de trabajo admirable. Ellos son más productivos cuando se les permite trabajar solo. Una buena elección " +
					"de carrera de bueyes son: diseñador de interiores, pintor, carpintero, trabajador de la cantera, el arqueólogo, horticultor, mecánico, ingeniero, dibujante, banquero, " +
					"agente de bienes raíces y oficial del ejército.";
			ox += "\n\nRELACIONES\n\n";
			ox += "Los bueyes no son muy sociables y rara vez participan en actividades de grupo. Detestan la pequeña charla y no pierden el tiempo coqueteando. Buscarán durante " +
					"mucho tiempo a la pareja perfecta ya que el cambio los hace sentir incómodos. Ya sea debido a la tendencia de un buey de ser arrogante o la tendencia a culpar a los " +
					"demás, las relaciones con los bueyes no siempre funcionan. Cuando los bueyes se dan cuenta que las alianzas implican dos personas y dos puntos de vista, la satisfacción " +
					"de las partes son posibles.";
			if (tipoAnimal == "metal"){
				ox += "\n\nBuey de Metal – Años 1901 y 1961\n\n";
				ox += "Como el metal, estos bueyes son increíblemente fuertes. Son personas muy trabajadoras que harán lo que sea necesario para lograr sus objetivos. Son personas de confianza, " +
						"confiables, que no es probable que muestren sus emociones. Tienen dificultad para interpretar los sentimientos de los demás.";
			}else if (tipoAnimal == "agua"){ 
				ox += "\n\nBuey de agua – Años 1913 y 1973\n\n";
				ox += "Los bueyes del agua son mucho más flexibles, y debido a esta cualidad, son más capaces de entender lo que otros están pensando y sintiendo. Son sinceros, pacientes, " +
						"rápidos de pensamiento y otros disfrutan de estar cerca de ellos.";
			}else if (tipoAnimal == "madera"){ 
				ox += "\n\nBuey de Madera – Años 1925 y 1985\n\n";
				ox += "El Buey de Madera trabaja bien como parte de un equipo, no por su ética de trabajo, confianza en sí mismo y un fuerte sentido de la moral, sino porque siempre funcionan " +
						"mejor como líder del equipo. Ellos tienen una tendencia a ser irascible y francos.";
			}else if (tipoAnimal == "fuego"){ 
				ox += "\n\nBuey de Fuego – Años 1937 y 1997\n\n";
				ox += "Los bueyes de Fuego son líderes naturales. De hecho, muchas veces ocupan puestos de importancia en el trabajo y en la comunidad. Ellos tienen fusibles cortos y tienden a " +
						"reaccionar de manera impulsiva en lugar de considerar la opinión de los demás.";
			}else if (tipoAnimal == "tierra"){ 
				ox += "\n\nBuey de Tierra – Años 1949 y 2009\n\n";
				ox += "Los bueyes de Tierra son personas de éxito, probablemente debido a que son diligentes y no impulsivos. Un enfoque más modesto combinado con su fiabilidad y sinceridad " +
						"los hace más agradables.";
			}else{
				ox = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			ox += "\n\nCompatibilidad\n\n";
			ox += "Los bueyes son compatibles con una Rata y Gallo e incompatible con un tigre y el caballo.";
			texto.setText(ox); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "rabbit") {

			String rabbit = "PERSONALIDAD\n\nOcupando la 4 ª posición en el zodiaco chino, la liebre (o el conejo) simboliza los rasgos de carácter tales como la creatividad, la compasión y " +
					"sensibilidad. Las liebres son amigables, sociables y prefieren la compañía de los demás. También prefieren evitar el conflicto. En situaciones de confrontación, " +
					"las liebres tiene un enfoque con calma y son considerados con la otra parte. Las liebres creen firmemente en los amigos y la familia y la ausencia de dichas " +
					"relaciones puede conducir a problemas emocionales.\n\n"+
					"Su carácter sereno evita que las liebres se vuelvan visiblemente molestos. Debido a que son animales serenos, las liebres son fáciles de abusar. Su naturaleza " +
					"sensible los hace huir de situaciones agresivas o competitivas. Son en general conservadores y no estan interesados en la toma de riesgos.\n\n" + 
					"Elegantes, sofisticados, expresivos, bien educados y con estilo, los nacidos bajo el signo de la liebre disfrutan de temas culturales y el aprendizaje sobre" + 
					"personas de otros países. Las liebres estan más cómodas en el hogar, y sus casas están siempre ordenados y organizadas. El hogar es también el lugar donde las" +
					" liebres prefieren entretenerse. Las liebres son conservadores en sus gustos de decoración.\n\n"+
					"Las liebres deben trabajar en la construcción de más confianza en sí mismo y la autoestima para que puedan sentirse más seguros. El deseo de permanecer en un " +
					"ambiente seguro, cómodo evita que los liebres tomen riesgos lo que a veces hace que se pierdan una buena oportunidad.";
			rabbit += "\n\nSALUD\n\n";
			rabbit += "A pesar de que las liebres no suelen mostrarse visiblemente molestos o estresados, ellos tienden a mantener estos sentimientos en su interior. " +
					"Cuando no expresan estos sentimientos, tales sentimientos pueden hacer que las liebres se enfermen. Las liebres pueden beneficiarse de una mayor actividad " +
					"cotidiana para reducir sus niveles de estrés y mejorar su salud.";
			rabbit += "\n\nCARRERA\n\n";
			rabbit += "Las liebres son articulados y buenos comunicadores, lo cual es la razón por lo que amigos y conocidos buscan su consejo. Es también la razón por la que las " +
					"liebres hacen de excelentes diplomáticos y políticos. Otras buenas carreras para las liebres son: escritor, editor, actor, diseñador de moda, terapeuta, médico, " +
					"administrador, relaciones públicas, y profesor.";
			rabbit += "\n\nRELACIONES\n\n";
			rabbit += "Las liebres son muy sexuales, pero tienden a dar más de sí mismos de lo que deberían. Esto puede conducir a expectativas poco realistas y situaciones insalubres. " +
					"Las liebres necesitan parejas que no se aprovechen de su naturaleza de dar. Tales emparejamientos serán fuertes.";
			if (tipoAnimal == "metal"){
				rabbit += "\n\nLiebres de Metal – Años 1951 y 2011\n\n";
				rabbit += "El Metal da a las liebres más fuerza, resistencia y determinación. Las liebres de metal son más intensos en sus acciones, ya sean de trabajo o románticas.";
			}else if (tipoAnimal == "agua"){ 
				rabbit += "\n\nLiebres de Agua – Años 1903 y 1963\n\n";
				rabbit += "Al igual que las corrientes de agua las liebres prefieren ir con la corriente, evitando los conflictos a toda costa, incluso en situaciones que son molestas. " +
						"Es fácil aprovecharse de las liebres. Son un gran apoyo para los demás.";
			}else if (tipoAnimal == "madera"){ 
				rabbit += "\n\nLiebres de Madera – Años 1915 y 1975\n\n";
				rabbit += "Las liebres de Madera ocupan su tiempo haciendo por los demás, siempre sintiendo la necesidad de poner contentos a los demás. Esta generosidad es fácil para " +
						"que otros se aprovechen de las liebres y, a veces las liebres no se dan cuentan de lo que está sucediendo.";
			}else if (tipoAnimal == "fuego"){ 
				rabbit += "\n\nLiebres de Fuego – Años 1927 y 1987\n\n";
				rabbit += "El Fuego añade una chispa a la personalidad de la liebre y todo lo que estas liebres hacen. El Fuego obliga a las liebres a buscar nuevas aventuras. " +
						"Propensas a las rabietas, las liebres de Fuego prefieren evitar el conflicto.";
			}else if (tipoAnimal == "tierra"){ 
				rabbit += "\n\nLiebres de Tierra – Años 1939 y 1999\n\n";
				rabbit += "Las ratas de Tierra prefieren un sentido de estabilidad, cavando y echando raíces temprano para ayudar a asegurar un futuro exitoso. Creen que lo lento y constante es el mejor enfoque. " +
						"Ser espontáneo es un rasgo innato, pero este tipo de comportamiento no se ajusta a las ratas de la Tierra";
			}else{
				rabbit = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			rabbit += "\n\nCompatibilidad\n\n";
			rabbit += "La liebre es más compatible con el cerdo y el perro e incompatible con el gallo y la rata.";
			texto.setText(rabbit); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "dog") {

			String dog = "PERSONALIDAD\n\nOcupando la posición 11 en el zodiaco chino, el perro simboliza los rasgos de carácter como la lealtad, la compatibilidad y la bondad. " +
					"Los perros con frecuencia ofrecen amables palabras y consejos útiles, siempre escuchando y prestando una mano cuando sea necesario. Los perros a menudo se " +
					"vuelven profundamente involucrados en las vidas de otros y a veces se los percibe como entrometidos. Asegurar que los demás son felices es más importante para " +
					"el perro que la riqueza, el dinero o el éxito.\n\n"+
					"Los perros son individuos determinados, siempre queriendo dominar un tema nuevo antes de seguir adelante y siempre terminando lo que comienzan. Los Perros valoran" +
					" las amistades, son leales, honestos, confiables y fiables y tienen una fuerte moral y ética.\n\n" +
					"Una casa bien cuidada y organizada es muy importante. Mantener un hogar limpio y ayudar en el trabajo deriva de la necesidad del perro por estar activo e involucrado. " +
					"Los Perros gastan el dinero sabiamente, prefiriendo los objetos prácticos ante que los bienes de lujo. Los perros también prefieren ahorrar dinero para cubrir gastos futuros.\n\n"+
					"Los perros a veces también pueden ser temperamentales, de mente estrecha y obstinados. Cuando esto sucede, el perro se aisla solo con el fin de hacer las cosas bien otra vez dentro de su cabeza. Los perros pueden beneficiarse de aprender a relajarse y ser más racionales.";
			dog += "\n\nSALUD\n\n";
			dog += "Un perro feliz es un perro sano y es fácil decir por su apariencia si esta triste o deprimido, o si el perro no se siente bien. Los perros son resistentes, " +
					"especialmente cuando luchan contra una enfermedad.";
			dog += "\n\nCARRERA\n\n";
			dog += "Los compañeros de trabajo siempre puede contar con los perros para ayudarlos, especialmente si esto significa que el perro va a aprender algo nuevo o aliviar la carga de trabajo " +
					"de los demás. Los perros son considerados como empleados valiosos. Una buena elección de carrera de perros son: oficial de policía, científico, consejero, diseñador de interiores, " +
					"profesor, político, sacerdote, enfermera, secretaria y el juez.";
			dog += "\n\nRELACIONES\n\n";
			dog += "Aunque los perros son dignos de confianza, tienen problemas para confiar en otros. Puede tomar mucho tiempo antes de que un perro se siente a gusto con otra persona. Cuando los perros no pueden confiar, son críticos y ásperos con los demás.\n\n"+
					"Cuando se trata de romance con frecuencia tienen un momento difícil. Otros se han asustado por la inseguridad del perro y frecuentemente por la naturaleza de su ansiedad. Los perros son conocidos por ser emocionalmente fríos y críticos.";
			if (tipoAnimal == "metal"){
				dog += "\n\nPerros de Metal – Años 1910 y 1970\n\n";
				dog += "Los perros de metal estan muy comprometidos en todo lo que hacen si se trata de trabajo o de relaciones. Las expectativas son altas, tanto para ellos mismos y otros.";
			}else if (tipoAnimal == "agua"){ 
				dog += "\n\nPerros de Agua – Años 1922 y 1982\n\n";
				dog += "Menos independientes, los perros de agua se vuelven más seguros de sí mismos cuando son parte del grupo. Ellos prefieren estar en el grupo en lugar de ser el líder de la manada. Son fieles, cariñosos, flexibles y relajados.";
			}else if (tipoAnimal == "madera"){ 
				dog += "\n\nPerros de madera – Años 1934 y 1994\n\n";
				dog += "Los perros de madera también prefieren ser parte del grupo ya que este ambiente construye confianza en sí mismos con el paso del tiempo. Aunque tímido al principio, los perros de madera con el tiempo pueden llegar a ser excelentes compañeros. Son fáciles de tratar, fieles, adaptables y de buen corazón.";
			}else if (tipoAnimal == "fuego"){ 
				dog += "\n\nPerros de Fuego – Años 1946 y 2006\n\n";
				dog += "Los Perros de Fuego son los verdaderos líderes. Otros disfrutan de estar en compañía de los Perros de Fuego. Son sexualmente atractivos, carismáticos, vibrantes y con confianza y siempre prefieren estar en movimiento.";
			}else if (tipoAnimal == "tierra"){ 
				dog += "\n\nPerros de Tierra – Años 1958 y 2018\n\n";
				dog += "La confiabilidad y la fiabilidad de los perros de Tierra hace de estos grandes líderes. Con un pie en la tierra, su sentido de la justicia le permite a los perros de Tierra ser de apoyo para con los demás. Ellos tienen " +
						"confianza e inspiran confianza en los demás.";
			}else{
				dog = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			dog += "\n\nCompatibilidad\n\n";
			dog += "El perro es el más compatible con el caballo o el tigre e incompatible con el Gallo y el Dragón.";
			texto.setText(dog); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "monkey") {

			String monkey = "PERSONALIDAD\n\nOcupando la posición 9 en el zodiaco chino, el mono posee rasgos de carácter tales como la curiosidad, picardía y astucia. Siempre jugueton, los monos son los maestros de las bromas. " +
					"A pesar de que sus intenciones son siempre buenas, este deseo de ser un bromista tiene una tendencia a crear mala voluntad y herir los sentimientos.\n\n"+
					"A pesar de que son intrínsecamente intelectuales y creativos, los monos a veces tiene problemas para exhibir estas cualidades. Cuando esto sucede, parecen a los demás estar  confundidos. " +
					"Pero nada podría estar más lejos de la verdad como monos prefieren ser perseguidos. Los monos prefieren la vida urbana a las zonas rurales, y su pasatiempo favorito es ver gente.";
			monkey += "\n\nSALUD\n\n";
			monkey += "Convencidos de que estar enfermo es una pérdida de un valioso día, los monos muy rara vez se sienten enfermos. Su estilo de vida de constante actividad es probablemente lo que ayuda a los monos a permanecer " +
					"en buen estado de salud. Cuando los monos se enferman, tales sentimientos son generalmente el resultado de sentirse nervioso.";
			monkey += "\n\nCARRERA\n\n";
			monkey += "Cuando se trata de trabajo, los monos pueden hacer casi cualquier cosa. Se adaptan bien a los ambientes cambiantes y son muy inteligentes. Ellos trabajan con rapidez, pero con frecuencia van a cobrar el doble por sus servicios. Buenos campos de " +
					"carrera de los monos son la contabilidad y la banca. Otras buenas carreras para los monos son: científico, ingeniero, comerciante del mercado de valores, controlador de tránsito aéreo, comerciante, director de cine, joyero y representante de ventas.";
			monkey += "\n\nRELACIONES\n\n";
			monkey += "Cuando se trata de relaciones, los monos no se apresuran a asentarse. De hecho, por lo general son promiscuos, una tendencia que probablemente tiene que ver con el hecho de que los monos se aburren fácilmente. Los Monos terminarán este tipo de " +
					"comportamiento una vez que se emparejan con la pareja perfecta. De hecho, la mayoría de las veces, ellos se comprometen a con esa persona en todos los sentidos para la vida.";
			if (tipoAnimal == "metal"){
				monkey += "\n\nMono de Metal – Años 1920 y 1980\n\n";
				monkey += "Los Monos de metal son determinado y ambiciosos y, en consecuencia, a menudo son exitosos. Aunque se les considera de buen corazón y muy simpáticos, su preferencia en la vida es estar solo. Los Monos de metal son leales a sus empleadores y sus parejas.";
			}else if (tipoAnimal == "agua"){ 
				monkey += "\n\nMono de Agua – Años 1932 y 1992\n\n";
				monkey += "Los Monos de agua son muy sensibles y se sienten heridos por las cosas que se dicen a ellos. Se niegan a mostrar su lado sensible a los demás y como resultado, son bromistas extremos. Si pueden mantener la concentración, pueden tener éxito, pero más a menudo que no, son fácilmente distraído de sus objetivos.";
			}else if (tipoAnimal == "madera"){ 
				monkey += "\n\nMono de Madera – Años 1944 y 2004\n\n";
				monkey += "Las habilidades excepcionales del mono de madera en cuanto a la comunicación es algo necesario para interactuar bien con los demás. Son muy trabajadores y tienen un profundo conocimiento de como las cosas funcionan.";
			}else if (tipoAnimal == "fuego"){ 
				monkey += "\n\nMono de Fuego – Años 1956 y 2016\n\n";
				monkey += "Lleno de fuerza y determinación, los monos de fuego son excelentes para ponerse objetivos y para el cumplimiento de ellos. Las personas disfrutan de estar en compañía de los monos de fuego, a pesar de que estos monos quieren prevalecer en las relaciones.";
			}else if (tipoAnimal == "tierra"){ 
				monkey += "\n\nMono de Tierra – Años 1908 y 1968\n\n";
				monkey += "Los monos de Tierra tienen un deseo inherente de vivir la vida de la manera “correcta”. Son muy confiables y se toman su trabajo y sus relaciones con seriedad. De hecho, ponen adelante 100% de esfuerzo en todo lo que hacen. A cambio, los monos Tierra esperan respeto de los demás.";
			}else{
				monkey = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			monkey += "\n\nCompatibilidad\n\n";
			monkey += "Los monos son compatibles con una rata o Dragon e incompatible con un caballo o de serpiente.";
			texto.setText(monkey); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "tiger") {

			String tiger = "PERSONALIDAD\n\nOcupando la tercera posición en el zodiaco chino, el tigre simboliza los rasgos de carácter tales como la valentía, la competitividad y la impredecibilidad. A los Tigres les encanta ser enfrentados y aceptan cualquier desafío si esto significa la protección de un ser querido o la protección de su honor. " +
					"No les preocupan los resultados porque saben que siempre caen de pie. No dejes que su apariencia tranquila te engañe; los Tigres saltarán cuando sientan que es necesario.\n\n"+
					"Nacido para el liderar, el Tigres puede ser terco, si se dan cuenta que no están a cargo. Ellos tienen una ligera tendencia a ser egoístas, pero en general, los Tigres son muy generosos. Son muy inteligentes y siempre están en alerta. Los tigres son muy encantadores y muy queridos por los demás. No están motivados por el dinero o el poder.";
			tiger += "\n\nSALUD\n\n";
			tiger += "Como lo hacen con sus enemigos, los Tigres tienen una tendencia a esforzarse sobre su trabajo. Después, se sientes agotados. A pesar de que pronto se vuelcan de nuevo al trabajo, con el tiempo este método puede causar problemas con su salud. " +
					"Los Tigres necesitan  desarrollar un enfoque más equilibrado a la vida para que puedan utilizar su energía de manera más eficiente.";
			tiger += "\n\nCARRERA\n\n";
			tiger += "Los tigres tienen una necesidad continua de ser enfrentados lo que puede explicar por qué saltan de un empleo a otro. Esto no es necesariamente un problema porque son inteligentes y capaces de dominar rápidamente los nuevos temas. Los mejores trabajos de los Tigres son los que los llevará hacia posiciones de liderazgo. " +
					"Algunas carreras adecuadas de los Tigres son: agente de publicidad, gerente de la oficina, agencia de viajes, actor, escritor, artista, piloto, azafata, comediante, músico y conductor.";
			tiger += "\n\nRELACIONES\n\n";
			tiger += "Son expresivos, amables y dignos de confianza, pero ten cuidado. Los Tigres tienden a dominar sus relaciones. Esta tendencia es instintiva y cuando son seguidos de cerca, este comportamiento se puede mantener bajo control. La pareja debe ser igualmente activas para mantenerse al día con sentido del Tigre de la aventura.";
			if (tipoAnimal == "metal"){
				tiger += "\n\nTigre de Metal – Años 1950 y 2010\n\n";
				tiger += "Asertivos, competitivos y fuertes, una vez que los Tigres de metal han puesto sus ojos en sus objetivos no hay nada que los detenga. Siempre haran lo necesario para permanecer en el centro de atención. Los Tigres de metal tienden a saltar a conclusiones, un comportamiento sobre el cual necesitan trabajar para mejorarlo.";
			}else if (tipoAnimal == "agua"){ 
				tiger += "\n\nTigre de Agua – Años 1902 y 1962\n\n";
				tiger += "Los Tigres de agua son sensibles y tranquilos. Se dan cuenta de que otras personas tienen opiniones muy dignas. Son muy intuitivos los que los hace buenos para juzgar con precisión las diferentes situaciones.";
			}else if (tipoAnimal == "madera"){ 
				tiger += "\n\nTigre de Madera – Años 1914 y 1974\n\n";
				tiger += "No sienten la necesidad de estar a cargo. Trabajan bien con los demás. Los otros disfrutan de estar cerca de los Tigres de madera porque son muy individuos generosos. Son compasivos y dispuestos a hacer lo que sea necesario para ayudar a otros.";
			}else if (tipoAnimal == "fuego"){ 
				tiger += "\n\nTigre de fuego – Años 1926 y 1986\n\n";
				tiger += "Expresivos, vibrantes y un poco excéntricos, Los Tigres de Fuego siempre están buscando el lado positivo de cada situación. Porque son capaces de generar entusiasmo en otros, son considerados excelentes líderes. Cuando los Tigres de Fuego hablan, los otros escuchan y hacen los que les dicen.";
			}else if (tipoAnimal == "tierra"){ 
				tiger += "\n\nTigre Tierra – Años 1938 y 1998\n\n";
				tiger += "Más basado en la realidad, los Tigres de Tierra no se dejan llevar por las circunstancias de la situación. En su lugar, se sientan y evaluan todos los ángulos antes de saltar. Son capaces de concentrarse en sus tareas, un rasgo que ayuda a asegurar el éxito.";
			}else{
				tiger = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			tiger += "\n\nCompatibilidad\n\n";
			tiger += "Los tigres son compatibles con un perro y un caballo y son incompatibles con una cabra y un buey.";
			texto.setText(tiger); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "dragon") {

			String dragon = "PERSONALIDAD\n\nOcupando el 5 º puesto en el zodiaco chino, el dragón es el más poderoso de los signos. Los dragones simbolizan los rasgos de carácter tales como el dominio y la ambición. " +
					"Los Dragones prefieren vivir por sus propias normas y si se deja por su cuenta, suelen tener éxito. No tienen miedo a los retos, y están dispuestos a tomar riesgos. Son apasionados " +
					"en todo lo que hacen y hacen cosas con gran estilo. Lamentablemente, esta pasión y el entusiasmo pueden dejar a los Dragones agotados.\n\n"+
					"Si bien los dragones con frecuencia ayudan a los demás, rara vez van a pedir ayuda. Otros se sienten atraídos por los dragones, sobre todo su" +
					" personalidad colorida, pero en el fondo, los dragones prefieren estar solos. Tal vez eso es porque son más exitosos cuando trabajan solos. Su" +
					" preferencia por estar solo puede se percibida como arrogancia, pero estas cualidades no son aplicables a los dragones. Los dragones tienen temperamentos que puede explotar rápido.";
			dragon += "\n\nSALUD\n\n";
			dragon += "Teniendo en cuenta su naturaleza, que trabajan duro, los dragones son saludables en general. Ellos se estresan y sufren de la tensión de forma periódica / dolores de cabeza, " +
					"probablemente porque tienen tantos riesgos. Los Dragones podrían beneficiarse de la incorporación de actividad moderada en sus vidas. Yoga o caminar sería bueno ya que estas " +
					"actividades pueden trabajar tanto en sus mentes y sus cuerpos.";
			dragon += "\n\nCARRERA\n\n";
			dragon += "Los Dragones prefieren liderar a ser liderados. Puestos de trabajo que les permita expresar su creatividad son buenas opciones. Algunas carreras son buenas: inventor, gerente, " +
					"analista informático, abogado, ingeniero, arquitecto, corredor y vendedor.";
			dragon += "\n\nRELACIONES\n\n";
			dragon += "Los dragones se dan en el amor, pero no renunciarán nunca a su independencia. Debido a que tienen a veces ánimos de venganza, sus parejas deben ser de piel dura. Los Dragones " +
					"disfrutan de personas que son intrigantes, y cuando encuentran a su pareja adecuada, por lo general va a comprometerse con esa persona de por vida.";
			if (tipoAnimal == "metal"){
				dragon += "\n\nLos dragones de metal – Años 1940 y 2000\n\n";
				dragon += "El Metal refuerza esta signo ya fuerte. Los Dragones de metal son más decididos y van a luchar por lo que creen. Disfrutan de la compañía de aquellos que se sienten poderosos como para desafiar a sus creencias. Ellos son los verdaderos líderes y suelen encontrar muchos otros dispuestos a seguirlos.";
			}else if (tipoAnimal == "agua"){ 
				dragon += "\n\nLos dragones de agua – Años 1952 y 2012\n\n";
				dragon += "El agua calma el fuego del Dragón. Los Dragones de agua son capaces de ver las cosas desde otros puntos de vista. Ellos no tienen la necesidad siempre de tener la razón. Sus decisiones suelen ser mejores ya que permiten que otros se involucren.";
			}else if (tipoAnimal == "madera"){ 
				dragon += "\n\nLos dragones de madera – 1904 y 1964\n\n";
				dragon += "Los dragones de madera también están dispuestos a escuchar las opiniones de los demás. Su faceta artística es fuerte, y los dragones de madera gusta ser creativos e innovadores. Ellos se llevan bien con otros, pero siempre serán la fuerza dominante.";
			}else if (tipoAnimal == "fuego"){ 
				dragon += "\n\nLos dragones de fuego – 1916 y 1976\n\n";
				dragon += "Las emociones de un Dragón de Fuego pueden estallar en un  instante. Los Dragones de fuego se ponen en un pedestal, y porque reaccionan de forma rápida y sin cuidado, a veces toman decisiones equivocadas. Los Dragones de Fuego necesitan reducir la velocidad y mantener su temperamento bajo control ya que es ahí cuando estan en su mejor estado.";
			}else if (tipoAnimal == "tierra"){ 
				dragon += "\n\nLos dragones de tierra – Años 1928 y 1988\n\n";
				dragon += "Más arraigados en la tierra, los dragones de Tierra toman mejores decisiones, ya que actuan de manera más racional. Los Dragones de Tierra son sensatos y capaces de controlar sus conductas. Apoyan a los demás, pero prefieren la admiración de los demás.";
			}else{
				dragon = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			dragon += "\n\nCompatibilidad\n\n";
			dragon += "Los dragones son compatibles con el mono o rata e incompatibles con el buey y la cabra.";
			texto.setText(dragon); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		
		if (nombreAnimal == "rooster") {

			String rooster = "PERSONALIDAD\n\nOcupando la 10 ª posición en el zodiaco chino, el gallo simboliza los rasgos de carácter tales como la confianza, pomposidad y la motivación. Los nacidos bajo el signo del Zodíaco Chino" +
					" del Gallo son personas leales, fieles, los cuales son contundentes a la hora de ofrecer sus opiniones. Su franqueza, no se deriva de ser malo, sino de ser honesto, un rasgo que los Gallos esperan de los demás.\n\n"+
					"Los gallos son muy sociables y prefieren ser el centro de atención, siempre presumiendo de sí mismos y sus logros. Ellos buscan continuamente la atención constante de los demás, algo que puede ser molesto. Los gallos " +
					"están tan orgullosos de sus hogares, así como de si mismos. Son personas muy organizadas como lo demuestra el hecho de que sus casas están siempre ordenadas.";
			rooster += "\n\nSALUD\n\n";
			rooster += "En general, los gallos son personas activas y su preferencia a estar activo ayuda a mantenerlos en buen estado de salud. Cuando se enferman, se sienten mejor rápidamente. Pueden a veces sin embargo, tomar en exceso" +
					" y cuando eso sucede, ellos se sienten estresados y de mal humor.";
			rooster += "\n\nCARRERA\n\n";
			rooster += "Los gallos son muy motivadores y muy trabajadores; rasgos que permiten a la mayoría de gallos de tener una carrera exitosa. No es de extrañar que los gallos hacen de buenos actores, músicos y bailarines. " +
					"Otras opciones de carrera buena para gallos son: banquero, dentista, agente de seguros, secretario y contador. A los Gallos también les va bien en las fuerzas armadas.";
			rooster += "\n\nRELACIONES\n\n";
			rooster += "El enfoque autoritario del gallo y honesto de “decir las cosas tal como son” no funciona bien con las personas sensibles. Los Gallos tienen la necesidad de asociarse con aquellos que son menos sensibles a las criticas. " +
					"Son los individuos más capaces de darse cuenta de que debajo de los exteriores duros tienen un corazón enorme, rebosante de amor.";
			if (tipoAnimal == "metal"){
				rooster += "\n\nGallo de Metal – Años 1921 y 1981\n\n";
				rooster += "Estos gallos tienen egos muy grandes y están siempre buscando oyentes dispuestos que pueden ayudarles a mantener los egos inflados. Los Gallos de Metal analizan todo. Su naturaleza agresiva evitan que algunas amistades y relaciones se desarrollen con normalidad...";
			}else if (tipoAnimal == "agua"){ 
				rooster += "\n\nGallo de Agua – Años 1933 y 1993\n\n";
				rooster += "El agua tiene un efecto calmante sobre este gallo. Los Gallos de agua no sienten la necesidad de elevarse por encima de la multitud y sus habilidades de comunicación son más refinadas. " +
						"Siempre enérgico y muy detallista, estos gallos pueden beneficiarse de permanecer más centrados en el resultado final más que en los pequeños detalles.";
			}else if (tipoAnimal == "madera"){ 
				rooster += "\n\nGallo de Madera – Años 1945 y 2005\n\n";
				rooster += "Más bien orientado al equipo, los gallos de madera tienen muchos amigos y conocidos. Siempre tratando de buscar el bien en lugar del mal en las personas, así como en situaciones de " +
						"la vida, su único defecto es la tendencia a no terminar lo que comienzan. Esto sucede debido a que con frecuencia toman más de lo que puede manejar.";
			}else if (tipoAnimal == "fuego"){ 
				rooster += "\n\nGallo de Fuego – Años 1957 y 2017\n\n";
				rooster += "Gallos en todos los sentidos, los Gallos de fuego pasan mucho de su tiempo perfeccionando sus imágenes. Son excelente organizadores sociales y líderes excelentes. " +
						"Sin embargo, son demasiado contundentes y esta característica a menudo hiere los sentimientos de los demás.";
			}else if (tipoAnimal == "tierra"){ 
				rooster += "\n\nGallos de Tierra – Años 1909 y 1969\n\n";
				rooster += "Extremadamentes organizados y detallistas, los Gallos de Tierra son excelentes para la multitarea. Están motivados por el éxito, y establecen altos estándares que esperan que otros sigan. " +
						"Estas expectativas de los demás puede conducir a la animosidad hacia los Gallos de Tierra por lo que necesitan adoptar un enfoque más sutil.";
			}else{
				rooster = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			rooster += "\n\nCompatibilidad\n\n";
			rooster += "Los gallos son más compatibles con un buey o de serpiente y la mayoría incompatibles con una cabra y un conejo.";
			texto.setText(rooster); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "ram") {

			String ram = "PERSONALIDAD\n\nOcupando la 8 ª posición en el zodiaco chino, la Cabra (u Oveja) simboliza los rasgos de carácter tales como la creatividad, inteligencia, seriedad y calma. " +
					"Cómodas estando a solas para reflexionar sobre el funcionamiento de su mente interior, las cabras pueden ser parte de un grupo, pero prefieren estar al margen en lugar del centro. " +
					"Su personalidad hace que las cabras sean excelentes cuidadoras. Son muy reservadas y pasan mucho tiempo absortas en sus pensamientos.\n\n"+
					"En sus casas es el único donde las cabras se sienten más cómodas. Allí pueden expresarse artísticamente, ya sea por la pintura, la cocina o participar en cualquiera de actividades " +
					"artísticas que disfrutan. Las cabras prefieren el sofá porque se pueden relajar y explorar sus mentes. No es necesario muebles muy elaborados, sólo los elementos que reflejan su deseo por el arte."+
					"Al viajar o buscar entretenimiento, las cabras prefieren los grupos o lugares que tienen muchas personas. Las cabras gastan dinero en moda que les da un aspecto de primera clase. " +
					"A pesar de las cabras les gusta pasar el dinero en las cosas buenas de la vida, no son esnobs.";
			ram += "\n\nSALUD\n\n";
			ram += "Tal vez porque las cabras son, básicamente, serenas, tienden a tener menos problemas de salud. Cuando están felices, están sanos. Cuando las cabras se vuelven infelices, " +
					"especialmente como resultado del romance, rápidamente se enferman.";
			ram += "\n\nCARRERA\n\n";
			ram += "Las cabras en el trabajo prefieren formar parte de un rebaño. Poder y estatus no son importantes. Las cabras sólo asumen roles de liderazgo cuando se les pregunta directamente. " +
					"Ellos nunca lo hacen voluntariamente. Buenas opciones de carrera para las cabras son: florista, diseñador de interiores, profesor de guardería, pediatra, actor, editor, estilista, ilustrador, músico y profesor de historia del arte.";
			ram += "\n\nRELACIONES\n\n";
			ram += "Las cabras tienden a ser privadas, por lo que puede suponer un esfuerzo para conocer a uno. La cabra es el que decidirá cuándo y con quién compartirá su vida personal. " +
					"Como resultado, la mayoría de las cabras tienen pocos amigos cercanos, sin embargo, va a trabajar duro para aquellos que ama.";
			if (tipoAnimal == "metal"){
				ram += "\n\nCabra de metal – Años 1931 y 1991\n\n";
				ram += "Estos gallos tienen egos muy grandes y están siempre buscando oyentes dispuestos que pueden ayudarles a mantener los egos inflados. Los Gallos de Metal analizan todo. Su naturaleza agresiva evitan que algunas amistades y relaciones se desarrollen con normalidad...";
			}else if (tipoAnimal == "agua"){ 
				ram += "\n\nCabra de agua – Años 1943 y 2003\n\n";
				ram += "Amante de la diversión y sin preocupaciones,  las cabras de Agua prefiere “ir con la corriente.” Estas características hacen de las cabras de agua agradable para estar juntos. Prefieren echar raíces. Hacen pucheros cuando las cosas no siguen su camino y les falta confianza en sí mismo.";
			}else if (tipoAnimal == "madera"){ 
				ram += "\n\nCabra de madera- Años 1955 y 2005\n\n";
				ram += "Otros disfrutan la compañía de las cabras de madera por lo que se siente más cómodo en grupos. Disfrutan de ser útil, pero a veces la gente toma ventaja de su generosidad. Las cabras de madera tienen necesidad de dedicar más tiempo a cuidar de sí mismos.";
			}else if (tipoAnimal == "fuego"){ 
				ram += "\n\nCabra de fuego- Años 1907 y 1967\n\n";
				ram += "No es tan sensible como las otras cabras, la cabra de fuego no necesita la aprobación de los demás. Las cabras de fuego siempre se ponen delante de los demás. Son criaturas sociales que normalmente tienen un círculo muy unido de la familia y amigos.";
			}else if (tipoAnimal == "tierra"){ 
				ram += "\n\nCabra de tierra- Años 1919 y 1979\n\n";
				ram += "Estable con los pies firmemente plantados en la tierra, las cabras de Tierra son conservadores, independientes y prácticos, pero no muy seguros de sí mismos. Lo más importante en la vida es la familia y realmente disfrutan de todos los que la vida tiene para ofrecer.";
			}else{
				ram = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			ram += "\n\nCompatibilidad\n\n";
			ram += "Las cabras son compatibles con los conejos y cerdos, e incompatible con la rata y el buey.";
			texto.setText(ram); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
		
		if (nombreAnimal == "horse") {

			String horse = "PERSONALIDAD\n\nOcupando la 7 ª posición en el zodiaco chino, el caballo simboliza los rasgos de carácter tales como fuerza, energía, y una naturaleza extrovertida. Muy animados, los caballos prosperan cuando son el centro de atención. " +
					"Siempre en busca de un buen momento, los caballos mantienen a las multitudes felices con su humor y su ingenio.\n\n"+
					"Los caballos son muy inteligentes por lo que son capaces de aprender nuevos temas con facilidad. También son capaces de multi-tarea,sin embargo no siempre termina lo que comienza porque están siempre persiguiendo la próxima oportunidad. " +
					"Los caballos son honestos, amables y de mente abierta. Son tal vez un poco demasiado centrados en sí mismos y se sabe que hacen berrinches cuando las situaciones no salen con la suya." +
					"A pesar de las cabras les gusta pasar el dinero en las cosas buenas de la vida, no son esnobs.";
			horse += "\n\nSALUD\n\n";
			horse += "Los caballos son muy sanos, muy probablemente debido a que mantienen una actitud positiva ante la vida y porque son atléticos. Lleva a los caballos a espacios amplios y abiertos, velos correr libremente! Los caballos por lo general sólo se sienten mal cuando están atrapados en el interior.";
			horse += "\n\nCARRERA\n\n";
			horse += "Los caballos disfrutan de posiciones en las que pueden interactuar con los demás. No les gusta recibir órdenes y ellos escaparan de puestos de trabajo que consideran de rutina. Son capaces de aprender nuevos temas con facilidad haciéndolos capaces de manejar casi cualquier trabajo. " +
					"Son comunicadores efectivos y gozan de poder. Una buena elección de carrera de caballos son: publicista, representante de ventas, periodista, profesor de idiomas, traductor, camarero, actor, operadores turísticos, bibliotecario o piloto.";
			horse += "\n\nRELACIONES\n\n";
			horse += "Los caballos, siendo espontáneos, tienen una tendencia a ser aceptados por los demás. Ellos tienden a darse plenamente en cada nueva relación calidad que termina socavando a su ser interior. Afortunadamente, este rasgo disminuye con la edad y las relaciones son más fuertes y más estables en el futuro.";
			if (tipoAnimal == "metal"){
				horse += "\n\nCaballo de Metal – Años 1930 y 1990\n\n";
				horse += "De espíritu libre en todos los sentidos de la palabra, el compromiso es la forma más fácil de asustar a los caballos de metal. Prefieren saltar de una relación o de un trabajo a otro. Debido a esto, los caballos de metal hacen mejores amigos que pareja.";
			}else if (tipoAnimal == "agua"){ 
				horse += "\n\nCaballo de Agua – Años 1942 y 2002\n\n";
				horse += "Adaptables pero indecisos, los caballos de agua tienen una tendencia a fluir como la corriente. Tienen problemas para hacer sus mentes y, en consecuencia, siempre parecen confundir a otros. Y aunque este comportamiento puede ser frustrante, los caballos de agua son divertidos para estar cerca de ellos, por lo que la mayoría la gente se acostumbre a ellos.";
			}else if (tipoAnimal == "madera"){ 
				horse += "\n\nCaballo de madera – Años 1954 y 2014\n\n";
				horse += "Estable y fuerte, los caballos de madera son más capaces de tomar decisiones. Ellos interactúan bien con los demás, un rasgo que les permite tener una relación personal y profesional más exitosa.";
			}else if (tipoAnimal == "fuego"){ 
				horse += "\n\nCaballo de Fuego – Años 1906 y 1966\n\n";
				horse += "El fuego se quema siempre dentro de los Caballos de Fuego. Les encanta vivir al límite y siempre están listos para cambiar a medida que el cambio siempre es más interesante. Son increíblemente obstinados.";
			}else if (tipoAnimal == "tierra"){ 
				horse += "\n\nCaballo de Tierra – Años 1918 y 1978\n\n";
				horse += "Los Caballos de la Tierra trabajan para alcanzar sus metas, no importa el tiempo que sea necesario. Tienen la capacidad de ver las situaciones desde todos los puntos de vista y esta capacidad es especialmente útil cuando se trata de la toma de decisiones. Son muy adaptables y son divertidos también.";
			}else{
				horse = "Error: Tipo de animal no soportado, contacte con el desarrollador y digale la fecha introducida. Gracias.";
			}
			horse += "\n\nCompatibilidad\n\n";
			horse += "Los caballos son compatibles con un perro o el tigre e incompatibles con una rata o mono.";
			texto.setText(horse); 
			/* texto.setText(Horoscopo.this.getResources().getString(R.string.snake));  Cambiar texto predefinido*/
		}
	}
}