load data2.dat 
stem(data2(:,1), data2(:,2))
axis([0, 15, 0, 2.5])
xlabel('Tiempo de sesi�n[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 2.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Microsc�pica]")

print -dpng "Traza2Micro.png"