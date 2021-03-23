load talkspurt.dat

subplot(2, 3, 1)
stem(talkspurt(:,1), talkspurt(:, 2))
xlabel('Tiempo de sesion[s]')
ylabel('Retardo de extremo a extremo[s]')
title('Retardo de extremo a extremo de paquetes de voz sobre Internet (VoIP)')
print('Traza2.png', '-dpng')


subplot(2, 3, 2)
plot(talkspurt(:,1), talkspurt(:,2))
xlabel('Tiempo de sesion[s]')
title('Retardo de extremo a extremo de paquetes de voz sobre Internet (VoIP)')
ylabel('Retardo de extremo a extremo[s]')
