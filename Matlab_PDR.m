%% Mobile Connection

connector on 12qw12qw;
m = mobiledev;

%% Turn on Accelerometer and Send data to Matlab

m.AccelerationSensorEnabled = 1;
m.Logging = 1;

%% Stop

m.Logging = 0;
[a, t] = accellog(m);

%% Plot Raw Sensor Data

plot(t, a);
legend('X', 'Y', 'Z');
xlabel('Relative time (s)');
ylabel('Acceleration (m/s^2)');
x = a(:,1);
y = a(:,2);
z = a(:,3);

% Calculate and plot magnitude.
mag = sqrt(sum(x.^2 + y.^2 + z.^2, 2));
plot(t, mag);
xlabel('Time (s)');
ylabel('Acceleration (m/s^2)');

% Accounting for gravity.
magNoG = mag - mean(mag);

% Plot magnitude.
plot(t, magNoG);
xlabel('Time (s)');
ylabel('Acceleration (m/s^2)');

%% Count Number of Steps Taken

% Use FINDPEAKS to determine the local maxima.
minPeakHeight = std(magNoG);
[pks, locs] = findpeaks(magNoG, 'MINPEAKHEIGHT', minPeakHeight);

numSteps = numel(pks);

hold on;
plot(t(locs), pks, 'r', 'Marker', 'v', 'LineStyle', 'none');
title('Counting Steps');
xlabel('Time (s)');
ylabel('Acceleration Magnitude, No Gravity (m/s^2)');
hold off;

%% Clean Up

m.AccelerationSensorEnabled = 0;
clear m;
