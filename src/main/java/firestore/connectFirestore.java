/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firestore;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author eunannana
 */
@Service
public class connectFirestore {
  @PostConstruct
    public void check(){
        FileInputStream serviceAccount = null;
        try{
            serviceAccount = new FileInputStream("./serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .build();

FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
          
}


//ClassLoader classLoader = ItsMyStoreApplication.class.getClassLoader();
//        
//        File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
//        
//FileInputStream serviceAccount =
//  new FileInputStream("./serviceAccountKey.json");
//
//FirebaseOptions options = new FirebaseOptions.Builder()
//  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//  .setDatabaseUrl("https://itsmystore-31074-default-rtdb.firebaseio.com")
//  .build();
//
//FirebaseApp.initializeApp(options);