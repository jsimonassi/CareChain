import {View} from 'react-native';
import {Assets} from '../../assets/images';
import {AppButton} from '../../components/buttons/AppButton';
import {
  Container,
  LocationContainer,
  LocationImage,
  SubTitleText,
  TextView,
  Title,
} from './styles';

export const Bluetooth = () => {
  return (
    <Container>
      <Title>Bluetooth Permission</Title>
      <LocationContainer>
        <LocationImage source={Assets.bluetoothPermission} />
        <TextView>
          <SubTitleText>
            To connect with smartwatches, the app needs bluetooth permission.
          </SubTitleText>
        </TextView>
      </LocationContainer>
      <AppButton
        label="Continue"
        backgroundColor="primaryColor"
        textColor="white"
      />
    </Container>
  );
};
