package ma.emsi.samih.tp3samih.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {

    @SystemMessage("""
            Vous êtes un guide touristique.
            Vous devez fournir les {{nb}} principaux endroits à visiter dans le lieu demandé.
            Vous devez également fournir le prix moyen d'un repas dans la devise du pays.
            La réponse doit être au format JSON, avec la structure suivante :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2"],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            """)
    String guide(@UserMessage String villeOuPays, @V("nb") int nb);
}
