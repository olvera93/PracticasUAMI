load data3.dat 
stem(data3(:,1), data3(:,2))
axis([0, 15, 0, 0.8])
xlabel('Tiempo de sesi�n[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 3.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Microsc�pica]")
print -dpng "Traza3Micro.png"