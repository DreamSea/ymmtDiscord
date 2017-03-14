
import java.util.List;
import java.util.Random;

import plugin.mousehunt.Mousehunt;
import plugin.mousehunt.data.ReaderWriter;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IEmoji;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class Main {
	private static Mousehunt mousehunt = new Mousehunt(new ReaderWriter());
	
	public static void main(String[] args) throws DiscordException, RateLimitException {
		IDiscordClient client = createClient(args[0]);
		client.login();
		
		EventDispatcher dispatcher = client.getDispatcher();
		
		dispatcher.registerListener(new IListener<MessageReceivedEvent>() {

			private Random r = new Random();
			
			@Override
			public void handle(MessageReceivedEvent event) {
				IMessage message = event.getMessage();
				
//				System.out.println("#"+message.getChannel().getName()+" @"+message.getAuthor().getName()+"."+message.getAuthor().getDiscriminator()+" "+message.getContent());
				
				if (message.getContent().equals(".quit") && isAdmin(event)) {
					try {
						mousehunt.save();
						event.getClient().logout();
					} catch (DiscordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (!message.getChannel().getName().equals("discorddungeon")) {
					return;
				}
				
				String result = mousehunt.process(message.getAuthor().getName(), message.getAuthor().getDiscriminator(), message.getContent());
				if (result != null) {
					try {
						message.getChannel().sendMessage(result);
					} catch (MissingPermissionsException | RateLimitException | DiscordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (message.getContent().equals(".poke")) {
					try {
						List<IEmoji> emojiList = message.getGuild().getEmojis();
						System.out.println(emojiList.size());
						IEmoji emoji = emojiList.get(r.nextInt(emojiList.size()));
						message.getChannel().sendMessage(emoji.toString());
					} catch (MissingPermissionsException e) {
						e.printStackTrace();
					} catch (RateLimitException e) {
						e.printStackTrace();
					} catch (DiscordException e) {
						e.printStackTrace();
					}
				}
			}

			private boolean isAdmin(MessageReceivedEvent event) {
				IDiscordClient client = event.getClient();
				IUser author = event.getMessage().getAuthor();
				
				if (isAdmin(client.getGuilds(), author)) {
					return true;
				}
				return false;
			}

			// check if author an admin in any of the guilds
			private boolean isAdmin(List<IGuild> guilds, IUser author) {
				for (IGuild guild : guilds) {
					List<IRole> roles = guild.getRoles();
					int highestRole = 0;
					for (IRole role : roles) {
						if (role.getPosition() > highestRole) {
							highestRole = role.getPosition();
						}
					}
					
					for (IRole role : guild.getRolesForUser(author)) {
						if (role.getPosition() == highestRole) {
							return true;
						}
					}
				}
				return false;
			}
		});
	}
	
	private static IDiscordClient createClient(String token) {
		ClientBuilder clientBuilder = new ClientBuilder();
		try {
			return clientBuilder.withToken(token).build();
		} catch (DiscordException e) {
			e.printStackTrace();
			return null;
		}
	}

}
