package ui;

import model.*;
import java.util.Scanner;

public class Main {

	private Scanner reader;
	private ControlSound controller;

	public Main() {
		reader = new Scanner(System.in);
		controller = new ControlSound();
	}

	public static void main(String[] args) {

		Main main = new Main();  
		int option = 0; 

		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

		main.getReader().close();

	}

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Store >>>>>");
		System.out.println(
				"1. Agregar a un usuario consumidor\n" +
				"2. Agregar usuario productor\n" +
				"3. Agreagar cancion \n" +
				"4. Agregar podcast\n"+
				"5. crear playlist\n"+
				"6. Compartir playlist\n"+
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){
		String id = ""; 
		String nickname = ""; 
		String url = ""; 
		String name = "";
		String albumName = "";
		String description = "";
		double sellValue = 0; 
		int minutes = 0; 
		int seconds = 0;
		int selection = 0;
        int hours = 0;
		String msj = "";
		String playListName = "";
		String songName = "";
		int pos = -1;
		int quantityOfElements = 0;
		int count = 0;
		AudioFile newAudioFile = null;
		PlayList playList = null;
		int pos1 = -1;
		switch(option){
			case 1: 
				System.out.println("Elige el tipo de usuario consumidor que deseas añadir\n"+
									"1.Estandar\n"+
									"2.Premium");
				selection = validateIntegerInput();
				if(selection == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				System.out.println("Escribe el nickname del usuario");
				nickname = reader.next();
				if(controller.verifyNickName(nickname)){
					System.out.println("el nickname esta en uso");
					break;
				}
				System.out.println("Escribe el id del usuario");
				id = reader.next();
				msj = controller.addSConsumer(selection, nickname, id);
				System.out.println(msj);
					break; 

				case 2: 
				System.out.println("Elige el tipo de usuario productor que deseas añadir\n"+
									"1.Artista\n"+
									"2.Creador de contenido");
				selection = validateIntegerInput();
				if(selection == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				System.out.println("Escribe el nickname del usuario");
				nickname = reader.next();
				if(controller.verifyNickName(nickname)){
					System.out.println("el nickname esta en uso");
					break;
				}
				System.out.println("Escribe el id del usuario");
				id = reader.next();
				System.out.println("Escribe el url de la imagen del usuario");
				url = reader.next();
				System.out.println("Escribe el nombre del artista");
				name = reader.next();
				msj = controller.addProducer(selection, nickname, id, url, name);
				break; 

			case 3: 
				System.out.println("Escribe el nombre de la cancion");
				name = reader.next();
				System.out.println("Escribe el url");
				url = reader.next();
				System.out.println("Escribe el valor de venta");
				sellValue = validateDoubleInput();
				if(sellValue == -1){
					System.out.println("valor invalido");
						reader.nextLine();
						break;
				}
				System.out.println("Escribe el nombre del album");
				albumName = reader.next();
				System.out.println("Elegi el genero de la canción\n"+
									"1.ROCK\n"+
									"2.POP\n"+
									"3.HOUSE\n"+
									"4.TRAP\n");
				selection = validateIntegerInput();
				if(selection == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				System.out.println("Escribe cuantos minutos dura la sanción");
				minutes = validateIntegerInput();
				if(minutes == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				System.out.println("Escribe cuantos segundos dura la canción fuera de los minutos exactos");
				seconds = validateIntegerInput();
				if(seconds == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				msj = controller.addSong(name, url, sellValue, albumName, selection, minutes, seconds);
				System.out.println(msj);
					break; 
			case 4:
				System.out.println("Escribe el nombre del podcast");
				name = reader.next();
				System.out.println("Escribe el url");
				url = reader.next();
				System.out.println("Elegi la categoria del podcast\n"+
									"1.ENTRETENIMIENTO\n"+
									"2.MODA\n"+
									"3.POLITICA\n"+
									"4.VIDEOJUEGOS");
				selection = validateIntegerInput();
				if(selection == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				System.out.println("escribe la descripcion");
				description = reader.next();
				System.out.println("escribe las horas exactas que dura el podcast");
				hours = validateIntegerInput();
				if(hours == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				System.out.println("Escribe los minutos que dura el podcast fuera de las horas exactas");
				minutes = validateIntegerInput();
				if(minutes == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				System.out.println("Escribe los segundos exactos que dura el podcast fuera de las horas y minutos");
				seconds = validateIntegerInput();
				if(seconds == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				msj = controller.addPodcast(albumName, url, selection, description, hours, minutes, seconds);
				System.out.println(msj);
				break;
			case 5:
				System.out.println("Escribe el nickname del usuario que quiere crear la playlist");
				name = reader.next();
				pos = controller.searchUserByNickName(name);
				if(pos!=-1){
					System.out.println("Escribe el nombre de la playlist");
					playListName = reader.next();
					System.out.println("Elige el tipo de playlist\n"+
										"1.CANCIONES\n"+
										"2.PODCASTS\n"+
										"3.CANCIONES Y PODCASTS");
					selection = validateIntegerInput();
					if(selection == -1){
						System.out.println("valor invalido");
						reader.nextLine();
						break;
					}
					System.out.println("Escribe el numero de elememtos que quieres añadir");
					quantityOfElements = validateIntegerInput();
					if(quantityOfElements == -1){
						System.out.println("valor invalido");
						reader.nextLine();
						break;
					}
					playList = controller.createPlayList(playListName, selection);
					do{ 
						System.out.println("Escribe el nombre de la cancion o podcast que quieres agregar");
						songName = reader.next();
						if(controller.searchAudioByName(songName)!=-1){
							pos1 = controller.searchAudioByName(songName);
							System.out.println(controller.searchAudioByName(songName));
							newAudioFile = controller.getAudioFiles().get(pos1);
							msj = playList.addAudio(newAudioFile);
							System.out.println(msj);
							count += 1;
						}else{
							msj = "no se encontro la cancion o podcast";
						}
					}while(count<quantityOfElements);
					if(controller.getUsers().get(pos) instanceof Consumer){
						msj = ((Consumer)((controller.getUsers().get(pos)))).addPlayList(playList);
					}
					
				}else{
					msj = "No se encontro al usuario";
				}
				System.out.println(msj);
			    break;
			case 6:
				System.out.println("Escribe el nickname del usuario propietario de la playlist");
				name = reader.next();
				pos = controller.searchUserByNickName(name);
				if(pos!=-1){
					System.out.println("escribe el nombre de la playlist");
					playListName = reader.next();
					pos1 = ((Consumer)((controller.getUsers().get(pos)))).searchPlaylistByName(playListName);
					if(pos1!=-1){
						playList = ((Consumer)((controller.getUsers().get(pos)))).getPlayLists().get(pos1);
						msj = controller.generateShareCodeForPlayList(playList.getType());
					}else{
						msj = "No se encontro la playlist";
					}
				}else{
					msj = "El usuario no fue encontrado";
				}
				System.out.println(msj);
				break;
			case 0: 
				System.out.println("Exit program.");
				break; 
			
			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	public Scanner getReader(){
		return reader; 
	}

	public int validateIntegerInput(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}
 
		return option; 
	}

	public double validateDoubleInput(){
		double option = 0; 

		if(reader.hasNextDouble()){
			option = reader.nextDouble(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}



}

