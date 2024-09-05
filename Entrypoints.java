import java.rmi.registry.Registry;

public class Entrypoints
{
    // In your mod class
    public static final ScreenHandlerType<GTScreenHandler> GRAVE_TOKEN_SCREEN_HANDLER_TYPE = Registry.register(Registries.SCREEN_HANDLER_TYPE, id("grave_token_screen_handler"), new ScreenHandlerType<>(GTScreenHandler::new, FeatureFlags.DEFAULT_SET));

    // In your client loader
    public static void clientInit()
    {
        HandledScreens.register(Minigame.GRAVE_TOKEN_SCREEN_HANDLER_TYPE, GTScreen::new);
    }
}