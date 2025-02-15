import {
  Container,
  ContainerDeviceNotFound,
  DeviceImg,
  SubContainer,
  SubTitleText,
  SubTitleTextDeviceNotFound,
  TitleText,
} from './styles';
import {Device} from './components/Device';
import {AppButton} from '../../components/buttons/AppButton';
import {useState} from 'react';
import {Assets} from '../../assets/images';

export const Scanning = () => {
  const [foundDevices, setFoundDevices] = useState(false);
  return (
    <Container>
      {foundDevices ? (
        <SubContainer>
          <SubTitleText>Select your device:</SubTitleText>
          <Device description="AB:AB:00:4T:55:CC" name="Life Ultra GPS" />
          <Device description="AB:AB:00:4T:55:CC" name="GTX44" />
          <Device description="AB:AB:00:4T:55:CC" name="IDW30" />
        </SubContainer>
      ) : (
        <ContainerDeviceNotFound>
          <DeviceImg source={Assets.device} />
          <TitleText>No devices nearby!</TitleText>
          <SubTitleTextDeviceNotFound>
            You can try again
          </SubTitleTextDeviceNotFound>
        </ContainerDeviceNotFound>
      )}

      <AppButton
        label="Search again"
        backgroundColor="primaryColor"
        textColor="white"
      />
    </Container>
  );
};
