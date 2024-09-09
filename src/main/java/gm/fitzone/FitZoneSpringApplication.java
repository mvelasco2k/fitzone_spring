package gm.fitzone;

import gm.fitzone.model.Client;
import gm.fitzone.service.IClientService;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class FitZoneSpringApplication implements CommandLineRunner{

    @Autowired
    private IClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(FitZoneSpringApplication.class);
    
    public static void main(String[] args) {
        
        //RunUp the Spring Factory
	SpringApplication.run(FitZoneSpringApplication.class, args);
        
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("**MENU DE OPCIONES**");
        Scanner input = new Scanner(System.in);
        String option = "";
        boolean loop = true;
        do{
            logger.info("1. Listar Clientes");
            logger.info("2. Buscar Cliente por ID");
            logger.info("3. Agregar Cliente");
            logger.info("4. Modificar Cliente");
            logger.info("5. Eliminar Cliente");
            logger.info("6. Salir");
            logger.info("Ingrese una opción: ");
            option = input.nextLine();
            logger.info("");
            
            switch(option){
                case "1":
                    System.out.println("**LISTADO DE CLIENTES**");
                    listClients();
                    break;
                case "2":
                    System.out.println("**BÚSQUEDA DE CLIENTE POR ID**");
                    clientById(input);
                    break;
                case "3":
                    System.out.println("**AGREGAR CLIENTE**");
                    createClient(input);
                    break;
                case "4":
                    System.out.println("**MODIFICAR CLIENTE**");
                    updateClient(input);
                    break;
                case "5":
                    System.out.println("**ELIMINAR CLIENTE**");
                    deleteClient(input);
                    break;
                case "6":
                    System.out.println("Gracias por utilizar el sistema de FitZone");
                    loop = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }while(loop);
    }
    
    public void listClients(){
        List<Client> listClients = clientService.listClients();
        listClients.forEach(client -> logger.info(client.toString()));
        logger.info("");
    }
    public void clientById(Scanner idQuery){
        logger.info("Ingrese el id del cliente que desea buscar: ");
        String search = idQuery.nextLine();
        Client c = clientService.findClientById(Integer.parseInt(search));
        
        if(c != null){
            logger.info("Cliente encontrado: "+c);
        }else{
            logger.info("Cliente no encontrado");
        }
        logger.info("");
    }
    public void createClient(Scanner data){
        logger.info("Ingrese el nombre del nuevo cliente: ");
        String name = data.nextLine();
        logger.info("Ingrese el apellido del nuevo cliente: ");
        String surname = data.nextLine();
        logger.info("Ingrese la membresía del nuevo cliente: ");
        String membresy = data.nextLine();
        
        Client newClient = new Client(null, name, surname, membresy);
        clientService.saveClient(newClient);
        
        logger.info("Cliente agregado: "+newClient);
        logger.info("");
    }
    public void updateClient(Scanner newData){
        logger.info("Ingrese el id del cliente a modificar: ");
        String idClient = newData.nextLine();
        logger.info("Ingrese el nombre modificado: ");
        String name = newData.nextLine();
        logger.info("Ingrese el apellido modificado: ");
        String surname = newData.nextLine();
        logger.info("Ingrese la membresía modificada: ");
        String membresy = newData.nextLine();
        
        Client updateClient = new Client(Integer.parseInt(idClient), name, surname, membresy);
        clientService.saveClient(updateClient);
        
        
        logger.info("Cliente modificado: "+updateClient);
        logger.info("");
    }
    public void deleteClient(Scanner input){
        logger.info("Ingrese el id del cliente que desea eliminar: ");
        String idClient = input.nextLine();
        
        Client deleteClient = clientService.findClientById(Integer.parseInt(idClient));
        clientService.deleteClient(deleteClient);
        
        
        logger.info("Cliente borrado");
        logger.info("");
    }
}
