package controller;

import model.LoginModel;

public class LoginController {
	
	public static Boolean userCheck(String usuario, String senha) {
		return LoginModel.userCheck(usuario, senha);
	}
}
