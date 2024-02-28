package com.yzanghelini.model.BO;

import java.util.List;


import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.PersistenceType;
import com.yzanghelini.model.DAO.DataBasePersistence;
import com.yzanghelini.model.DAO.PersistenceFactory;
import com.yzanghelini.model.DTO.Usuario;

public class UsuarioBO {

//	List<UsuarioDTO> users = new ArrayList<>(); => ArrayList
// private DataPersistence<Usuario> dataPersistence;
private DataBasePersistence<Usuario> dataPersistence;



// public UsuarioBO(PersistenceType persistenceType) {
//     this.dataPersistence = PersistenceFactory.setDataPersistence(Usuario.class, persistenceType);
    
// }

public UsuarioBO(PersistenceType persistenceType) {
    this.dataPersistence = (DataBasePersistence<Usuario>) PersistenceFactory.setDataPersistence(Usuario.class, persistenceType);
}

public void criarUsuario(Usuario usuario) {
    if (usuario.getId() <= 0) {
      usuario.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(usuario);
}

public Object[] logarUsuario(String nome, String senha) {
    return dataPersistence.autenticar(nome, senha);
}


public Usuario buscarUsuario(int id) {
    return dataPersistence.read(id);
}

public void atualizarUsuario(Usuario usuario) {
    dataPersistence.update(usuario);
}

public void deletarUsuario(int id) {
    dataPersistence.delete(id);
}

public List<Usuario> listarUsuarios() {
    return dataPersistence.readAll();
}


// public void registrarUsuarioBD(Usuario usuario) {
//     Usuario novoUsuario = new Usuario(usuario.getNome(), usuario.getSenha());
// //        users.add(novoUsuario);  => ArrayList, usar no xml e json
//     salvarUsuarioNoBanco(novoUsuario);
// }


 



// private Usuario encontrarUsuario(String nome) {
//     for (Usuario usuario : users ) {
//         if (usuario.getNome().equals(nome)) {
//             return usuario;
//         }
//     }
//     return null;
// }


}


