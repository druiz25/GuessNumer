# Proyecto: GuessNumer
Autor: Daniel Ruiz Villodres <br />
Minimum SDK: API 21 Android 5.0 (Lollipop)

# Desglose del proyecto
-Clase PartidaGuessNumer
  implementa la interfaz Serializable, Parcelable para pasar el objeto de la partida de una activity a otra con el intent.

En esta clase decidi crear dos constructores uno con todos sus campos y otro que solo pidiera el usuario, numero de intentos y el estado de la partida, este ultimo lo uso en la ConfigActivity introduciendo solo el usuario y numero de tiradas, en la PlayActivity contando ya con el resto de valores uso el constructor completo, aparte cuenta con los getter y setter de todas sus propiedades como los metodos que vienen de las interfazes implementadas.

# -ConfigActivity
  Diseño activity <br />
[![ConfigActivity](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiBQB8d_oGUjOlH4RrN7A5l8ZEggXpQHd9rDm-spai37WS7rMPE6AClIyvYw70XETRB2s0Ih7ymeXL9tQKmwWi0VicZgU32zx3d8_gbtpg3HTnM1y4bMaaqlg7notOBw21f4-yakS1XvUpydOdmFSMDTY_ZiCsY8Cz81a_NYxeh3Z5rRRr1OfXqvA-uyg/s320/2.PNG "ConfigActivity")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiBQB8d_oGUjOlH4RrN7A5l8ZEggXpQHd9rDm-spai37WS7rMPE6AClIyvYw70XETRB2s0Ih7ymeXL9tQKmwWi0VicZgU32zx3d8_gbtpg3HTnM1y4bMaaqlg7notOBw21f4-yakS1XvUpydOdmFSMDTY_ZiCsY8Cz81a_NYxeh3Z5rRRr1OfXqvA-uyg/s320/2.PNG "ConfigActivity")

Contiene dos edit text para introducir el usuario y el numero de intentos aparte de un  boton para enviar los datos recogidos en un objeto de la clase PartidaGuessNumer que se introducira en un bundle a menos que dejes algun campo sin rellenar en caso de que esto ocurra no se crea un objeto de la clase y aparecera un toast avisando de que hay algun campo sin rellenar.


# -PlayActivity 
  Diseño activity  <br />
[![PlayActivity](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjEAvAU7cxLxLmqdiDv5wgVyScjPaw45QJI4CtfZ5Z4SklLaQdNiF1xyUByWl0ylx3gaMmiXEEPdRDYCQ8YBOvu8llQU5ARuUwUfHTk8kSwIRJ0U_Ug0vBO513SUFp8hKqKDljHwDBA2GufILaKZH3toyf4TRrj-ikr7u7ArtlpnlBjdBZFXNx3vvoBKg/s320/3.PNG "PlayActivity")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjEAvAU7cxLxLmqdiDv5wgVyScjPaw45QJI4CtfZ5Z4SklLaQdNiF1xyUByWl0ylx3gaMmiXEEPdRDYCQ8YBOvu8llQU5ARuUwUfHTk8kSwIRJ0U_Ug0vBO513SUFp8hKqKDljHwDBA2GufILaKZH3toyf4TRrj-ikr7u7ArtlpnlBjdBZFXNx3vvoBKg/s320/3.PNG "PlayActivity")


Activity cuando introduces un numero mayor  <br />
[![ActivityPlay2](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiwK4tBTXAJ1KGpsPBO59LXJUPa4-lFhDtobu2t97kBgc9-PZ_Pgdh8YfikZr6pFYQGRtB1Z4f9n3FSSOFqOCzLNyiBR-NrKwJ_dylS8wsVJ6Uk62uN2lJ_kx37iLmYpRadPpUR1kjLgBPDSacLxlW-KJYE4VZD2JpfMsreIGnZmnEpTiXOd-6XK9lfHg/s320/5.PNG "ActivityPlay2")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiwK4tBTXAJ1KGpsPBO59LXJUPa4-lFhDtobu2t97kBgc9-PZ_Pgdh8YfikZr6pFYQGRtB1Z4f9n3FSSOFqOCzLNyiBR-NrKwJ_dylS8wsVJ6Uk62uN2lJ_kx37iLmYpRadPpUR1kjLgBPDSacLxlW-KJYE4VZD2JpfMsreIGnZmnEpTiXOd-6XK9lfHg/s320/5.PNG "ActivityPlay2")


Activity cuando introduces un numero menor  <br />
[![ActivityPlay3](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh4D-S7Qds97yKq47ZcJdyuQcySDjCDmoeOrK3xW8QuGv0UFWqnGIJGDrb8z3-mtsKDH8evBg8vmTMdiKqzYCEOLO02_uAqekvw7fmXSf2Zy5HG6G21H6TFb_wH3C8f3R47AazTe7t7SyG9qBux18vci_nyj55nq_rxPyNjM7h2imylq0KQCfrN-0Asdw/s320/6.PNG "ActivityPlay3")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh4D-S7Qds97yKq47ZcJdyuQcySDjCDmoeOrK3xW8QuGv0UFWqnGIJGDrb8z3-mtsKDH8evBg8vmTMdiKqzYCEOLO02_uAqekvw7fmXSf2Zy5HG6G21H6TFb_wH3C8f3R47AazTe7t7SyG9qBux18vci_nyj55nq_rxPyNjM7h2imylq0KQCfrN-0Asdw/s320/6.PNG "ActivityPlay3")


Contiene un text view para enseñar el resultado del intento en caso de que se falle indicara si el numero introducido fue menor/mayor que el numero secreto, un edit text donde el usuario introducira el numero para ver si coincide con el numero secreto y un boton que usa el metodo comprobarRespuesta que en caso de que falles suma un fallo mas a la cuenta de intentos fallidos y si te quedas sin intentos o aciertas crea una intancia de PartidaGuessNumer introduciendo los datos obtenidos del bundle y los conseguidos en esta activity como el numero secreto y el numero de fallos, estos son enviados en un intent con el bundle a la EndPlayActivity.

# -EndPlayActivity
  Diseño activity  <br />
[![EndPlayActivity](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj7xQ_O3vC_9GQ-d2IoBR-tW5NGcNwnZP2UHHm1byi9XE6h0Adm0tnDA4AvT-mWdF9R5aonitFHH1DKQWl7jLGJACfMX_YIC7PT7W7PSapoFX0ddksEi8tlxmYc6BEhEaLpRncSRRhpRb_POex7ij_pGAoayidogW4QGV1FGD_vm3eylZO4Pn6uaUv3yw/s320/4.PNG "EndPlayActivity")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj7xQ_O3vC_9GQ-d2IoBR-tW5NGcNwnZP2UHHm1byi9XE6h0Adm0tnDA4AvT-mWdF9R5aonitFHH1DKQWl7jLGJACfMX_YIC7PT7W7PSapoFX0ddksEi8tlxmYc6BEhEaLpRncSRRhpRb_POex7ij_pGAoayidogW4QGV1FGD_vm3eylZO4Pn6uaUv3yw/s320/4.PNG "EndPlayActivity")

  Activity en caso de acertar  <br />
[![ActivityEndPlay2](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiDO_aU8k27oAOVlgceZ-n8-Wnb6i-ewNbtdABSApicGoKXcWP7AtDeQUUZdEkGxdR2lN_hqQD2q-ZxMQXeaExt-Sp5blbnAuZ09TfZj8hv8-yXnpeWe8jIPw9vjvIiQT6R2urrybxJwYgH4dJCCCRRLMV6BcRDHRYjrCqJKwtrNYdIs0ev3SnXKa2Ayw/s320/7.PNG "ActivityEndPlay2")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiDO_aU8k27oAOVlgceZ-n8-Wnb6i-ewNbtdABSApicGoKXcWP7AtDeQUUZdEkGxdR2lN_hqQD2q-ZxMQXeaExt-Sp5blbnAuZ09TfZj8hv8-yXnpeWe8jIPw9vjvIiQT6R2urrybxJwYgH4dJCCCRRLMV6BcRDHRYjrCqJKwtrNYdIs0ev3SnXKa2Ayw/s320/7.PNG "ActivityEndPlay2")

  Activity en caso de agotar los intentos  <br />
[![ActivityEndPlay3](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhQo-q-zYVlHYGMNBYhePXIPfgIn_uzMbEK_W93arhUHYTVgEjkOhisepDqYF5sciezeIdaqES51zpN181TW73ow9UOB5n-fTtU-mdRxZu1tZqH6IZ1YH0SCeh1PBlF9_84bfzTWW5_pFOpIAjMfsztqKKSfaRf9ozGRsATkv97qJNqD58867-l3kradw/s320/8.PNG "ActivityEndPlay3")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhQo-q-zYVlHYGMNBYhePXIPfgIn_uzMbEK_W93arhUHYTVgEjkOhisepDqYF5sciezeIdaqES51zpN181TW73ow9UOB5n-fTtU-mdRxZu1tZqH6IZ1YH0SCeh1PBlF9_84bfzTWW5_pFOpIAjMfsztqKKSfaRf9ozGRsATkv97qJNqD58867-l3kradw/s320/8.PNG "ActivityEndPlay3")

Solo tiene un textView que enseña el resultado si el usuario acerto se le muestra el numero de veces que fallo y si se quedo sin oportunidades se le muestra cual era el numero secreto para decidir esto coje la instancia PartidaGuessNumer y lee el booleano victoria, si es false es que el usuario perdio y si es true es que acerto el numero y a aparte de esa instancia saca el numero secreto y los intentos del usuario. <br /> <br/>

Aparte se cambio el icono predeterminado de la aplicacion por otro mas adecuado. <br /> <br />
[![iconoGuessNumber](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhpBXFi0zK1XGMh2Uyw71DtaLxx6jfxkJAw7XZMWizi7k5JIzO_GCU5rgoF4s3UBmsVt_IcAVvUPOqhdQR5bh8DTrRdd_Iegncy-uDeCzkxjOaHild6-y76W23ZafV2B2oDoo_NMLopcvgK4kC82ZdChtDiJHlYaAreYu9cipEHTiS3LARh7gqFNNTu5w/s1600/icono.PNG "iconoGuessNumber")](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhpBXFi0zK1XGMh2Uyw71DtaLxx6jfxkJAw7XZMWizi7k5JIzO_GCU5rgoF4s3UBmsVt_IcAVvUPOqhdQR5bh8DTrRdd_Iegncy-uDeCzkxjOaHild6-y76W23ZafV2B2oDoo_NMLopcvgK4kC82ZdChtDiJHlYaAreYu9cipEHTiS3LARh7gqFNNTu5w/s1600/icono.PNG "iconoGuessNumber")
