import {Text, View} from 'react-native';
import {
  DeviceButton,
  DeviceContainerInside,
  DeviceTextDescription,
  DeviceTextTitle,
} from './styles';

interface DeviceProps {
  name: string;
  description: string;
}

export const Device = ({description, name}: DeviceProps) => {
  return (
    <DeviceButton>
      <DeviceContainerInside>
        <DeviceTextTitle>{name}</DeviceTextTitle>
        <DeviceTextDescription>{description}</DeviceTextDescription>
      </DeviceContainerInside>
    </DeviceButton>
  );
};
