/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
//import com.google.cloud.firestore.v1.FirestoreClient;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;
import com.google.firebase.cloud.FirestoreClient;
import entity.myStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author eunannana
 */
public class myService {

public String addmyStore(myStore mystore)throws ExecutionException, InterruptedException{
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> collectionsApiFuture = (ApiFuture<WriteResult>) dbFirestore.collection("mystore_product").document(mystore.getProductID());
    
    return collectionsApiFuture.get().getUpdateTime().toString();
}

public myStore getmyStore(String productID) throws ExecutionException, InterruptedException{
    Firestore dbFirestore = FirestoreClient.getFirestore();
    DocumentReference documentReference = dbFirestore.collection("productID").document(productID);
    ApiFuture<DocumentSnapshot> future = documentReference.get();
    
    DocumentSnapshot document = future.get();
    myStore mystore = null;
    if(document.exists()){
        mystore = document.toObject(myStore.class);
        return mystore;
    }
    
    return null;
}

 public List<myStore> getmyStoreAll() throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference=dbfirestore.collection("productID").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<myStore> myStoreList =new ArrayList<>();
        myStore mystore = null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot doc = future.get();
           mystore = doc.toObject(myStore.class);
           myStoreList.add(mystore);
        }
        return myStoreList;
    }


public String updatemyStore(myStore mystore) throws InterruptedException, ExecutionException{
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("mystore_product").document(mystore.getProductID()).set(mystore);
    return collectionsApiFuture.get().getUpdateTime().toString();
}
public String deletemyStore(String productID){
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> writeResult = dbFirestore.collection("mystore_product").document(productID).delete();
    return "Successfully deleted " + productID;
}
    
}
