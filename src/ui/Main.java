package ui;

import model.*;
import java.util.Scanner;

public class Main {

	private Scanner reader;
	private ControlSound controller;

	public Main() {
		reader = new Scanner(System.in);
		controller = new ControlSound();
		controller.initAds();
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
				"6. Editar playList\n"+
				"7. Compartir playlist\n"+
				"8. Comprar canción\n"+
				"9. Reproducir canción\n"+
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){
		String id = ""; 
		String nickName = ""; 
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
		int pos2 = -1;
		String artistId = "";
		String creatorId = "";
		int answer = 0;
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
				nickName = reader.next();
				if(controller.verifyNickName(nickName)){
					System.out.println("el nickname esta en uso");
					break;
				}
				System.out.println("Escribe el id del usuario");
				id = reader.next();
				if(controller.verifyId(id)){
					System.out.println("el nickname esta en uso");
					break;
				}
				msj = controller.addSConsumer(selection, nickName, id);
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
				nickName = reader.next();
				if(controller.verifyNickName(nickName)){
					System.out.println("el nickname esta en uso");
					break;
				}
				System.out.println("Escribe el id del usuario");
				id = reader.next();
				if(controller.verifyId(id)){
					System.out.println("el id esta regisrado");
					break;
				}
				System.out.println("Escribe el url de la imagen del usuario");
				url = reader.next();
				System.out.println("Escribe el nombre del artista");
				name = reader.next();
				msj = controller.addProducer(selection, nickName, id, url, name);
				break; 

			case 3: 
				System.out.println("Escribe el nombre de la cancion");
				name = reader.next();
				if(controller.verifyAudiofileName(name)){
					System.out.println("Nombre ya registrado");
					break;
				}
				System.out.println("Escribe el url");
				url = reader.next();
				System.out.println("Escribe el valor de venta");
				sellValue = validateDoubleInput();
				if(sellValue == -1){
					System.out.println("valor invalido");
						reader.nextLine();
						break;
				}
				System.out.println("Escribe el id del artista al que pertenece la cancion");
				artistId = reader.next();
				if(!controller.verifyArtistId(artistId)){
					System.out.println("El artista no esta registrado o el id pertenece a un usuario que no es un artista");
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
				msj = controller.addSong(name, url, sellValue, albumName,artistId, selection, minutes, seconds);
				System.out.println(msj);
					break; 
			case 4:
				System.out.println("Escribe el nombre del podcast");
				name = reader.next();
				if(controller.verifyAudiofileName(name)){
					System.out.println("Nombre ya registrado");
					break;
				}
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
				System.out.println("escribe el id del creador");
				creatorId = reader.next();
				if(!controller.verifyCreatorId(creatorId)){
					System.out.println("El creador no esta registrado o el id pertenece a un usuario que no es creador de contenido");
					break;
				}
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
				msj = controller.addPodcast(albumName, url, selection, description,creatorId, hours, minutes, seconds);
				System.out.println(msj);
				break;
			case 5:
				System.out.println("Escribe el nickname del usuario que quiere crear la playlist");
				name = reader.next();
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
				msj = controller.addPlayListToUser(name, playListName,selection,name);
				System.out.println(msj);
				System.out.println("Escribe el numero de elememtos que quieres añadir");
				quantityOfElements = validateIntegerInput();
				if(quantityOfElements == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				do{ 
					System.out.println("Escribe el nombre de la cancion o podcast que quieres agregar");
					songName = reader.next();
					msj = controller.addAudioToPlayList(name, songName, playListName);
					count += 1;
					System.out.println(msj);
				}while(count<quantityOfElements);
				count = 0;
				System.out.println(msj);
			    break;
			case 6:
				System.out.println("Escribe el nickname del usuario propietario de la playlist");
				name = reader.next();
				System.out.println("Escribe el nombre de la playList");
				playListName = reader.next();
				System.out.println("elegi que deseas hacer con la playLIst\n"+
									"1.Agregar cancion\n"+
									"2.Eliminar cancion\n");
				selection = validateIntegerInput();
				if(selection == -1){
					System.out.println("valor invalido");
					reader.nextLine();
					break;
				}
				switch(selection){
					case 1:
					System.out.println("Escribe el numero de elememtos que quieres añadir");
					quantityOfElements = validateIntegerInput();
					if(quantityOfElements == -1){
						System.out.println("valor invalido");
						reader.nextLine();
						break;
					}
					do{ 
						System.out.println("Escribe el nombre de la cancion o podcast a agregar");
						songName = reader.next();
						msj = controller.addAudioToPlayList(name, songName, playListName);
						System.out.println(msj);
					}while(count<quantityOfElements);
					break;
					case 2:
					System.out.println("Escribe el numero de elememtos que quieres eliminar");
					quantityOfElements = validateIntegerInput();
					if(quantityOfElements == -1){
						System.out.println("valor invalido");
						reader.nextLine();
						break;
					}
					do{ 
						System.out.println("Escribe el nombre de la cancion o pdcast a eliminar");
						songName = reader.next();
						msj = controller.removeAudioOfPLayList(nickName, songName, playListName);
						count += 1;
						System.out.println(msj);
					}while(count<quantityOfElements);
					break;
				}
				count = 0;
				System.out.println(msj);
				break;
			case 7:
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
			case 8:
			System.out.println("Escribe el nickname del usuario que quiere comprar una cancion");
			nickName = reader.next();
			System.out.println("Escribe el nombre de la cancion");
			songName = reader.next();
			msj = controller.BuyASong(nickName, songName);
			System.out.println(msj);
				break;
			case 9:
			System.out.println("Escribe el nickname del usuario que quiere reproducir la cancion");
			name = reader.next();
			do{
				System.out.println("Escribe el nombre de la cancion o podcast que quieres reproducir");
				songName = reader.next();
				if(controller.searchUserByNickName(name)!=-1){
					pos = controller.searchAudioByName(songName);
					if(pos != -1){
						if(controller.getUsers().get(controller.searchUserByNickName(name)) instanceof StandarConsumer){
							if(controller.getAudioFiles().get(pos) instanceof Song){
								if(count ==0 || count%2 !=0 ){
									msj = controller.playAudio(name, songName);
									System.out.println(msj);
									System.out.println("¿Continuar?"+"\n"+
													"1.Si"+"\n"+
													"2.No");
									answer = validateIntegerInput();
									count += 1;
								}else{
									msj = controller.playAnAd();
									System.out.println(msj);
									msj = controller.playAudio(name, songName);
									System.out.println(msj);
								}
							}else if(controller.getAudioFiles().get(pos) instanceof Podcast){
								msj = controller.playAnAd();
								System.out.println(msj);
								msj = controller.playAudio(name, songName);
								System.out.println(msj);
								System.out.println("¿Continuar?"+"\n"+
													"1.Si"+"\n"+
													"2.No");
								answer = validateIntegerInput();
							}
						}else if(controller.getUsers().get(controller.searchUserByNickName(name)) instanceof PremiumConsumer){
							msj = controller.playAudio(name, songName);
							System.out.println(msj);
							System.out.println("¿Continuar?"+"\n"+
												"1.Si"+"\n"+
												"2.No");
							answer = validateIntegerInput();
						}
					}else{
						msj = "podcast o cancion no encotrado";
						System.out.println(msj);
					}
				}
					
			}while(answer==1);
			if(answer==-1){
				System.out.println("valor invalido");
				break;
			}
				break;
			case 10:
			msj = controller.getTotalReproductionsForAudioFileType();
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

