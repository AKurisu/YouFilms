package untad.aldochristopher.youfilms.utils

import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.data.FilmEntity

object DataDummy {

    fun generateDummy(): FilmEntity{

        val film = FilmEntity("A123","Dummy","Lorem Ipsum","1 January 1970","-",1)

        return film
    }

    fun generateDataMovie(): List<FilmEntity> {

        val movie = ArrayList<FilmEntity>()

        movie.add(FilmEntity("tt0081398",
        "Raging Bull",
        "When Jake LaMotta steps into a boxing ring and obliterates his opponent, he's a prizefighter. But when he treats his family and friends the same way, he's a ticking time bomb, ready to go off at any moment. Though LaMotta wants his family's love, something always seems to come between them. Perhaps it's his violent bouts of paranoia and jealousy. This kind of rage helped make him a champ, but in real life, he winds up in the ring alone.",
        "19 December 1980",
        "Biography, Drama, Sport",
        R.drawable.poster_ragingbull))
        movie.add(FilmEntity("tt0816692",
                "Interstellar",
                "Earth's future has been riddled by disasters, famines, and droughts. There is only one way to ensure mankind's survival: Interstellar travel. A newly discovered wormhole in the far reaches of our solar system allows a team of astronauts to go where no man has gone before, a planet that may have the right environment to sustain human life.",
                "7 November 2014",
                "Adventure, Drama, Sci-Fi",
                R.drawable.poster_interstellar))
        movie.add(FilmEntity("tt6751668",
                "Parasite",
                "Jobless, penniless, and, above all, hopeless, the unmotivated patriarch, Ki-taek, and his equally unambitious family--his supportive wife, Chung-sook; his cynical twentysomething daughter, Ki-jung, and his college-age son, Ki-woo--occupy themselves by working for peanuts in their squalid basement-level apartment. Then, by sheer luck, a lucrative business proposition will pave the way for an ingeniously insidious scheme, as Ki-woo summons up the courage to pose as an English tutor for the teenage daughter of the affluent Park family. Now, the stage seems set for an unceasing winner-take-all class war. How does one get rid of a parasite?",
                "8 November 2019",
                "Comedy, Drama, Thriller",
                R.drawable.poster_parasite))
        movie.add(FilmEntity("tt0167404",
                "The Sixth Sense",
                "To wipe the slate clean and get a chance to redeem himself after that soul-scarring incident one year ago, the Philadelphia child psychologist, Dr Malcolm Crowe, decides to take on his first new case--the profoundly troubled eight-year-old boy, Cole Sear. Exhibiting the same symptoms like one of his former patients, Cole goes one step further by solemnly claiming he has the gift, or curse, of a rare and unwelcome sixth sense; the mysterious ability to see the dreadful and unquiet spectres of the deceased who linger in this earth. However, can a slowly-recovering sceptic believe, let alone, heal, a desperate soul crying for help? And, what if Cole's disturbingly recurring apparitions are not figments of an injured fantasy, but an irrefutable reality?",
                "6 August 1999",
                "Drama, Mystery, Thriller",
                R.drawable.poster_thesixthsense))
        movie.add(FilmEntity("tt0118849",
                "Children of Heaven",
                "Ali is asked to repair the torn shoes of his sister, Zohra, while buying groceries. A garbageman takes them, and a guilt-ridden Ali apologetically offers to share his shoes with her. So Zohra ends up wearing his shoes to morning school, then must race back so that he can put them on to attend afternoon school. To placate her, he even gives her a pen that he received from his teacher after coming first in his class. With the birth of a third child, the family struggles to make ends meet. Their father, who is behind on his rent, does gardening chores, and wants Ali to learn this trade. With the economic situation getting worse, it is only a matter of time when even Ali's shoes will wear out - bringing out the question: what will the children wear to school then?",
                "22 January 1999",
                "Drama, Family, Sport",
                R.drawable.poster_childrenofheaven))
        movie.add(FilmEntity("tt0083658",
                "Blade Runner",
                "In the early twenty-first century, the Tyrell Corporation, during what was called the Nexus phase, developed robots, called \"replicants\", that were supposed to aid society, the replicants which looked and acted like humans. When the superhuman generation Nexus 6 replicants, used for dangerous off-Earth endeavors, began a mutiny on an off-Earth colony, replicants became illegal on Earth. Police units, called \"blade runners\", have the job of destroying - or in their parlance \"retiring\" - any replicant that makes its way back to or created on Earth, with anyone convicted of aiding or assisting a replicant being sentenced to death. It's now November, 2019 in Los Angeles, California. Rick Deckard, a former blade runner, is called out of retirement when four known replicants, most combat models, have made their way back to Earth, with their leader being Roy Batty. One, Leon Kowalski, tried to infiltrate his way into the Tyrell Corporation as an employee, but has since been able to escape.",
                "25 June 1982",
                "Action, Sci-Fi, Thriller",
                R.drawable.poster_bladerunner))
        movie.add(FilmEntity("tt0892769",
                "How to Train Your Dragon",
                "Long ago up North on the Island of Berk, the young Viking, Hiccup, wants to join his town's fight against the dragons that continually raid their town. However, his macho father and village leader, Stoik the Vast, will not allow his small, clumsy, but inventive son to do so. Regardless, Hiccup ventures out into battle and downs a mysterious Night Fury dragon with his invention, but can't bring himself to kill it. Instead, Hiccup and the dragon, whom he dubs Toothless, begin a friendship that would open up both their worlds as the observant boy learns that his people have misjudged the species. But even as the two each take flight in their own way, they find that they must fight the destructive ignorance plaguing their world.",
                "26 March 2010",
                "Animation, Action, Adventure",
                R.drawable.poster_howtodragon))
        movie.add(FilmEntity("tt0031381",
                "Gone with the Wind",
                "In the face of the imminent U.S. Civil War, the pampered socialite and petulant Southern Belle, Scarlett O'Hara, basks in the limelight, enjoying a lavish lifestyle. Knowing that the rich and red-hued soil of Tara--the ancestral cotton plantation in Georgia--is the only thing worth fighting for, the resilient woman will do everything in her power to control her destiny; including marrying the wrong men to maintain her enviable social status. However, death seems to follow Scarlett--and as she swears never to be poor again, standing on the sparkling ashes of her beloved but burned-to-the-ground home--the cynical playboy, Rhett Butler, offers a way out, and a new lease of life. Headstrong, passionate, and, above all, resolute, not even war--or death--can stand in Scarlett's way; nevertheless, love is delicate and elusive, and, somehow, it is always one step ahead of her. Has Scarlett's noble aspiration for a better future gone with the wind?",
                "17 January 1940",
                "Drama, History, Romance",
                R.drawable.poster_gonewind))
        movie.add(FilmEntity("tt0055031",
                "Judgment at Nuremberg",
                "It has been three years since the most important Nazi leaders had already been tried. This trial is about 4 judges who used their offices to conduct Nazi sterilization and cleansing policies. Retired American judge, Dan Haywood has a daunting task ahead of him. The Cold War is heating up and no one wants any more trials as Germany, and Allied governments, want to forget the past. But is that the right thing to do is the question that the tribunal must decide.",
                "18 December 1961",
                "Drama, War",
                R.drawable.poster_judgementat))
        movie.add(FilmEntity("tt0266543",
                "Finding Nemo",
                "A clown fish named Marlin lives in the Great Barrier Reef and loses his son, Nemo, after he ventures into the open sea, despite his father's constant warnings about many of the ocean's dangers. Nemo is abducted by a boat and netted up and sent to a dentist's office in Sydney. While Marlin ventures off to try to retrieve Nemo, Marlin meets a fish named Dory, a blue tang suffering from short-term memory loss. The companions travel a great distance, encountering various dangerous sea creatures such as sharks, anglerfish and jellyfish, in order to rescue Nemo from the dentist's office, which is situated by Sydney Harbour. While the two are searching the ocean far and wide, Nemo and the other sea animals in the dentist's fish tank plot a way to return to the sea to live their lives free again.",
                "30 May 2003",
                "Animation, Adventure, Comedy",
                R.drawable.poster_findingnemo))

        return movie
    }

    fun generateDataTvShow() : List<FilmEntity> {

        val tvshow = ArrayList<FilmEntity>()

        tvshow.add(FilmEntity("tt0318871",
        "Berserk",
        "Guts was brought up by a mercenary group since birth. After killing his guardian in self-defence, he runs away. Years later, he encounters Griffith and The Band of the Hawk. The Hawks fight for the King of Midland, and after winning the 100-year war against the neighbouring Chuda, they become the King's personal guard. However, once they reach the top, things take a turn for the worse.",
        "1997 - 1998",
        "Animation, Action, Adventure, Horror",
        R.drawable.poster_berserk))
        tvshow.add(FilmEntity("tt4834232",
                "Critical Role",
                "The campaign follows a group of adventurers in the world of Exandria where they accomplish many tasks that lead them throughout the continent of Tal'Dorei and beyond. The farther they go on their journey the more they learn just how big the world can be and how heavy a weight it can impose; along with how chaotic, cold, and cruel. Will this band of misfits survive their little adventure and is there more waiting unseen beyond the edge of their perception? The only way to find out is to watch their stories unfold within the glorious episodes of....Critical Role....",
                "2015 - ",
                "Adventure, Fantasy",
                R.drawable.poster_criticalrole))
        tvshow.add(FilmEntity("tt3398540",
                "Haikyuu!!",
                "Hinata Shouyou, a short middle school student, gained a sudden love of volleyball after watching a national championship match on TV. Determined to become like the championship's star player, a short boy nicknamed \\\"the small giant\\\", Shouyou joined his school's volleyball club. Unfortunately, he was the only member and the club didn't have so much as a place to practice. He didn't let that deter him, however, and, upon finally acquiring 5 other players in his final year, was able to compete in an actual competition - only for his team to be unlucky enough to face the championship favorite and its star player, Kageyama Tobio, called \\\"the king of the court\\\", in the first round. Though Shouyou's team suffers a crushing defeat, he vows to become better and eventually surpass Kageyama. Now Shouyou is starting his first year in high school - the very one he had first watched in the national championships. He's going to join the volleyball team, practice constantly, and wipe the floor with Kageyama the next time they meet on the court. ...or at least that's what Shouyou had planned, until he discovers that he and Kageyama are now in the same school. The volleyball team definitely needs their skills, but only if they can stop bickering and learn to work together as teammates.",
                "2014 - 2020",
                "Animation, Comedy, Drama, Sport",
                R.drawable.poster_haikyuu))
        tvshow.add(FilmEntity("tt2303687",
                "Line of Duty",
                "Line of Duty follows Detective Seargent Steve Arnott (Martin Compston), an former authorized firearms officer who led an operation to catch an Islamic terrorist intending to detonate a bomb, but the strike team mistakenly entered the wrong apartment and shot dead an unarmed innocent man. In the subsequent investigation Arnott refused to cover up negligence in the planning and execution of the raid and unable to work in his unit anymore, Arnott receives a transfer to AC-12, a unit tasked with uncovering police corruption. Arnott is partnered with D.C. Kate Fleming (Vicky McClure), a highly-commended undercover officer with a keen investigative instinct. They work under the supervision of Superintendent Ted Hastings (Adrian Dunbar), who is one of several Senior Investigating Officers responsible for uncovering corruption within the police force. Throughout the series, AC-12 investigate seemingly disparate cases involving seemingly-corrupt police officers, with each series focusing on a different corrupt officer and AC-12 soon realize the pervasive nature of corruption and the police's deep-rooted links to an organized crime group with ties to drug running, prostitution, child exploitation and people trafficking.",
                "2012 - ",
                "Crime, Drama, Mystery",
                R.drawable.poster_lineofduty))
        tvshow.add(FilmEntity("tt1534360",
                "Ezel",
                "Omer is a young man, full of beauty and good spirit. He has just returned from military service and is about to marry the girl of his dreams, the stunning Eysan. His two best friends, Cengiz and Ali are like brothers to him, and he trusts them with all his heart. Everything seams perfect, as his whole life lies in front of him. The drama starts when the police storms into Omer's bedroom when he is still sleeping. He gets arrested for a murder and robbery at the casino the night before. Omer gets imprisoned for the crime - his life is shattered, friends and fiancé disappears. Instead, one single question is preyed on his mind for the next ten years: Why? It is obvious that Omer has been set up, but could such a terrible crime really have been planned by his two best friends and his fiancé Eysan? Omer gets eventually declared dead in prison, but the death is a cover up for the revenge to come. After plastic surgery Omer returns as Ezel, with only one mission in life - to find an explanation, and to take everything away from those who once destroyed his life. But first, he has to kill the constant, incorrigible, and endless love he still carries for the girl of his dreams, Eysan.",
                "2009 - 2011",
                "Crime, Drama, Thriller",
                R.drawable.poster_ezel))
        tvshow.add(FilmEntity("tt4236770",
                "Yellowstone",
                "Yellowstone follows the Dutton family, led by John Dutton, who controls the largest contiguous ranch in the United States, under constant attack by those it borders - land developers, an Indian reservation, and America's first National Park. It is an intense study of a violent world far from media scrutiny - where land grabs make developers billions, and politicians are bought and sold by the world's largest oil and lumber corporations. Where drinking water poisoned by fracking wells and unsolved murders are not news: they are a consequence of living in the new frontier. It is the best and worst of America seen through the eyes of a family that represents both.",
                "2018 - ",
                "Drama, Western",
                R.drawable.poster_yellowstone))
        tvshow.add(FilmEntity("tt3895150",
                "Shigatsu wa kimi no uso",
                "Piano prodigy Arima Kousei dominated the competition and all child musicians knew his name. But after his mother, who was also his instructor, passed away, he had a mental breakdown while performing at a recital that resulted in him no longer being able to hear the sound of his piano even though his hearing was perfectly fine. Even two years later, Kousei hasn't touched the piano and views the world in monotone, and without any flair or color. He was content at living out his life with his good friends Tsubaki and Watari until, one day, a girl changed everything. Miyazono Kaori is a pretty, free spirited violinist whose playing style reflects her personality. Kaori helps Kousei return to the music world and show that it should be free and mold breaking unlike the structured and rigid style Kousei was used to.",
                "2014 - 2015",
                "Animation, Drama, Music",
                R.drawable.poster_shigatsu))
        tvshow.add(FilmEntity("tt4295140",
                "Chef's Table",
                "Chef's Table goes inside the lives and kitchens of six of the world's most renowned international chefs. Each episode focuses on a single chef and their unique look at their lives, talents and passion from their piece of culinary heaven.",
                "2015 - ",
                "Documentary",
                R.drawable.poster_chef))
        tvshow.add(FilmEntity("tt4288182",
                "Atlanta",
                "Atlanta is one of the top cities for young rappers looking to make a name for themselves in the business. Among those up-and-comers is Alfred Miles, a hot new artist who is trying to understand the line between real life and street life. He is managed by his cousin, Earn, who gets caught up in the local rap scene and his cousin's career after returning home to the ATL. Earn does whatever he can to try to get Alfred's career to the next level. Darius, the rapper's right-hand man and visionary, is also in Alfred's entourage. When Earn isn't busy managing his cousin's career, he spends much of his time with best friend Vanessa, who is also the mother of his daughter.",
                "2016 - ",
                "Comedy, Drama, Music",
                R.drawable.poster_atlanta))
        tvshow.add(FilmEntity("tt4574334",
                "Stranger Things",
                "In a small town where everyone knows everyone, a peculiar incident starts a chain of events that leads to the disappearance of a child, which begins to tear at the fabric of an otherwise peaceful community. Dark government agencies and seemingly malevolent supernatural forces converge on the town, while a few of the locals begin to understand that there's more going on than meets the eye.",
                "2016 - ",
                "Drama, Fantasy, Horror",
                R.drawable.poster_stranger))

        return tvshow
    }

}