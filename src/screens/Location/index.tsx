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

export const Location = () => {
  return (
    <Container>
      <Title>Location Permission</Title>
      <LocationContainer>
        <LocationImage source={Assets.LocationPermission} />
        <TextView>
          <SubTitleText>
            To connect with BLE bluetooth devices, the app needs location
            permission.
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
