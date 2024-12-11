% y = mx + b

m = 2;
b = 3;
range = 10;

x = [1: range]
y = zeros(size(x));

for i = 1:length(x)
    y(i) = m * x(i) + b;
end

display('new y:');
disp(y)


%salter
saltValues = 5;
saltedValuesY = zeros(size(y));

for i = 1:length(y)
    random = randi([1, saltValues]);
    choice = randi([1, 2]);
    if choice == 1
        saltedValuesY(i) = y(i) + random;
    else
        saltedValuesY(i) = y(i) - random;
    end
end
display('salted:');
disp(saltedValuesY)



%smoother
windowValue = 3;
smoothedValuesY = zeros(size(x));
average = 0;
for i = 1:length(saltedValuesY)
    total = 0;
    amount = 0;
    if i <= windowValue
        j = 1;
        while j <= i + windowValue && j <= length(saltedValuesY)
            total = total + saltedValuesY(j);
            j = j + 1;
            amount = amount + 1;
        end
        average = floor(total / amount);
        smoothedValuesY(i) = average;
    elseif i > windowValue && i < length(saltedValuesY) - windowValue
        k = i - windowValue;
        while k <= i + windowValue && j < length(saltedValuesY)
            total = total + saltedValuesY(k);
            k = k + 1;
            amount = amount + 1;
        end
        average = floor(total / amount);
        smoothedValuesY(i) = average;
    else
        l = i - windowValue;
        while l <= length(saltedValuesY)
            total = total + saltedValuesY(l);
            l = l + 1;
            amount = amount + 1;
        end
        average = floor(total / amount);
        smoothedValuesY(i) = average;
    end
end

display('smoothed:')
disp(smoothedValuesY)


%Plot
figure;
plot(x,y, '-b', 'DisplayName', 'Orginal');
hold on;
plot(x,saltedValuesY, '-r', 'DisplayName', 'Salted');
plot(x,smoothedValuesY, '-y', 'DisplayName', 'Smoothed');
hold off;


title("Function Y=mx +b with Salter and Smoother")
xlabel('x-values');
ylabel('y-values');
legend;
grid on;




