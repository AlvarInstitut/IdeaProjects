package classes

import classes.SessionFactoryUtil
import classes.Poblacio
import classes.Comarca
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val q = sessio.createQuery("select c.nomC,count(p.codM),avg(p.altura) "
            + "from Comarca c , Poblacio p "
            + "where c.nomC=p.comarca.nomC "
            + "group by c.nomC "
            + "order by c.nomC");
    for (i in q.list()){
        i as Array<Object>
        println("Comarca: " + i[0] + ". Núm. pobles: " + i[1] + ". Altura mitjana: " + i[2]);
    }
    sessio.close()
}